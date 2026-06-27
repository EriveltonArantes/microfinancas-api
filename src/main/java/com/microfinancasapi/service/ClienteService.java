package com.microfinancasapi.service;

import com.microfinancasapi.dto.ClienteRequestDTO;
import com.microfinancasapi.dto.ClienteResponseDTO;
import com.microfinancasapi.exception.ResourceNotFoundException;
import com.microfinancasapi.mapper.ClienteMapper;
import com.microfinancasapi.model.Cliente;
import com.microfinancasapi.repository.ClienteRepository;
import com.microfinancasapi.repository.GrupoRepository;
import com.microfinancasapi.model.Grupo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Autowired
    private ClienteMapper mapper;

    @Autowired
    private GrupoRepository grupoRepository;

    @Transactional(readOnly = true)
    public List<ClienteResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ClienteResponseDTO buscar(Long id) {
        Cliente entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public ClienteResponseDTO criar(ClienteRequestDTO dto) {
        Cliente entity = mapper.toEntity(dto);
        Grupo grupo = grupoRepository.findById(dto.getGrupoId())
            .orElseThrow(() -> new ResourceNotFoundException("Grupo não encontrado com id: " + dto.getGrupoId()));
        entity.setGrupo(grupo);
        Cliente salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public ClienteResponseDTO atualizar(Long id, ClienteRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Cliente não encontrado com id: " + id);
        }
        Cliente entity = mapper.toEntity(dto);
        entity.setId(id);
        Grupo grupo = grupoRepository.findById(dto.getGrupoId())
            .orElseThrow(() -> new ResourceNotFoundException("Grupo não encontrado com id: " + dto.getGrupoId()));
        entity.setGrupo(grupo);
        Cliente salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Cliente não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
