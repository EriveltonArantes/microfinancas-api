package com.microfinancasapi.service;

import com.microfinancasapi.dto.GrupoRequestDTO;
import com.microfinancasapi.dto.GrupoResponseDTO;
import com.microfinancasapi.exception.ResourceNotFoundException;
import com.microfinancasapi.mapper.GrupoMapper;
import com.microfinancasapi.model.Grupo;
import com.microfinancasapi.repository.GrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class GrupoService {

    @Autowired
    private GrupoRepository repository;

    @Autowired
    private GrupoMapper mapper;

    @Transactional(readOnly = true)
    public List<GrupoResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public GrupoResponseDTO buscar(Long id) {
        Grupo entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Grupo não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public GrupoResponseDTO criar(GrupoRequestDTO dto) {
        Grupo entity = mapper.toEntity(dto);
        Grupo salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public GrupoResponseDTO atualizar(Long id, GrupoRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Grupo não encontrado com id: " + id);
        }
        Grupo entity = mapper.toEntity(dto);
        entity.setId(id);
        Grupo salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Grupo não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
