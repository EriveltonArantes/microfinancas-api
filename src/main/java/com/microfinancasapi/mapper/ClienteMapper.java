package com.microfinancasapi.mapper;

import com.microfinancasapi.dto.ClienteRequestDTO;
import com.microfinancasapi.dto.ClienteResponseDTO;
import com.microfinancasapi.model.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    @Mapping(target = "grupo", ignore = true)
    Cliente toEntity(ClienteRequestDTO dto);

    @Mapping(target = "grupoId", source = "grupo.id")
    ClienteResponseDTO toResponseDTO(Cliente entity);
}
