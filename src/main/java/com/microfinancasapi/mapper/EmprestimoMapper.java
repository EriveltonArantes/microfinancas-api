package com.microfinancasapi.mapper;

import com.microfinancasapi.dto.EmprestimoRequestDTO;
import com.microfinancasapi.dto.EmprestimoResponseDTO;
import com.microfinancasapi.model.Emprestimo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EmprestimoMapper {

    @Mapping(target = "cliente", ignore = true)
    @Mapping(target = "grupo", ignore = true)
    Emprestimo toEntity(EmprestimoRequestDTO dto);

    @Mapping(target = "clienteId", source = "cliente.id")
    @Mapping(target = "grupoId", source = "grupo.id")
    EmprestimoResponseDTO toResponseDTO(Emprestimo entity);
}
