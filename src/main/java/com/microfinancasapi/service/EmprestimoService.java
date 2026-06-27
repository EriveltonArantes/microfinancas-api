package com.microfinancasapi.service;

import com.microfinancasapi.dto.EmprestimoRequestDTO;
import com.microfinancasapi.dto.EmprestimoResponseDTO;
import com.microfinancasapi.exception.ResourceNotFoundException;
import com.microfinancasapi.mapper.EmprestimoMapper;
import com.microfinancasapi.model.Emprestimo;
import com.microfinancasapi.repository.EmprestimoRepository;
import com.microfinancasapi.repository.ClienteRepository;
import com.microfinancasapi.model.Cliente;
import com.microfinancasapi.repository.GrupoRepository;
import com.microfinancasapi.model.Grupo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class EmprestimoService {

    @Autowired
    private EmprestimoRepository repository;

    @Autowired
    private EmprestimoMapper mapper;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private GrupoRepository grupoRepository;

    @Transactional(readOnly = true)
    public List<EmprestimoResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public EmprestimoResponseDTO buscar(Long id) {
        Emprestimo entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Emprestimo não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public EmprestimoResponseDTO criar(EmprestimoRequestDTO dto) {
        Emprestimo entity = mapper.toEntity(dto);
        Cliente cliente = clienteRepository.findById(dto.getClienteId())
            .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado com id: " + dto.getClienteId()));
        entity.setCliente(cliente);
        Grupo grupo = grupoRepository.findById(dto.getGrupoId())
            .orElseThrow(() -> new ResourceNotFoundException("Grupo não encontrado com id: " + dto.getGrupoId()));
        entity.setGrupo(grupo);
        Emprestimo salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public EmprestimoResponseDTO atualizar(Long id, EmprestimoRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Emprestimo não encontrado com id: " + id);
        }
        Emprestimo entity = mapper.toEntity(dto);
        entity.setId(id);
        Cliente cliente = clienteRepository.findById(dto.getClienteId())
            .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado com id: " + dto.getClienteId()));
        entity.setCliente(cliente);
        Grupo grupo = grupoRepository.findById(dto.getGrupoId())
            .orElseThrow(() -> new ResourceNotFoundException("Grupo não encontrado com id: " + dto.getGrupoId()));
        entity.setGrupo(grupo);
        Emprestimo salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Emprestimo não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
