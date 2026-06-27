package com.microfinancasapi.service;

import com.microfinancasapi.dto.ParcelaRequestDTO;
import com.microfinancasapi.dto.ParcelaResponseDTO;
import com.microfinancasapi.exception.ResourceNotFoundException;
import com.microfinancasapi.mapper.ParcelaMapper;
import com.microfinancasapi.model.Parcela;
import com.microfinancasapi.repository.ParcelaRepository;
import com.microfinancasapi.repository.EmprestimoRepository;
import com.microfinancasapi.model.Emprestimo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ParcelaService {

    @Autowired
    private ParcelaRepository repository;

    @Autowired
    private ParcelaMapper mapper;

    @Autowired
    private EmprestimoRepository emprestimoRepository;

    @Transactional(readOnly = true)
    public List<ParcelaResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ParcelaResponseDTO buscar(Long id) {
        Parcela entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Parcela não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public ParcelaResponseDTO criar(ParcelaRequestDTO dto) {
        Parcela entity = mapper.toEntity(dto);
        Emprestimo emprestimo = emprestimoRepository.findById(dto.getEmprestimoId())
            .orElseThrow(() -> new ResourceNotFoundException("Emprestimo não encontrado com id: " + dto.getEmprestimoId()));
        entity.setEmprestimo(emprestimo);
        Parcela salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public ParcelaResponseDTO atualizar(Long id, ParcelaRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Parcela não encontrado com id: " + id);
        }
        Parcela entity = mapper.toEntity(dto);
        entity.setId(id);
        Emprestimo emprestimo = emprestimoRepository.findById(dto.getEmprestimoId())
            .orElseThrow(() -> new ResourceNotFoundException("Emprestimo não encontrado com id: " + dto.getEmprestimoId()));
        entity.setEmprestimo(emprestimo);
        Parcela salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Parcela não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
