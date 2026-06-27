package com.microfinancasapi.mapper;

import com.microfinancasapi.dto.GrupoRequestDTO;
import com.microfinancasapi.dto.GrupoResponseDTO;
import com.microfinancasapi.model.Grupo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface GrupoMapper {

    Grupo toEntity(GrupoRequestDTO dto);

    GrupoResponseDTO toResponseDTO(Grupo entity);
}
