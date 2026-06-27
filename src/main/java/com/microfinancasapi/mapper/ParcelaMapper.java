package com.microfinancasapi.mapper;

import com.microfinancasapi.dto.ParcelaRequestDTO;
import com.microfinancasapi.dto.ParcelaResponseDTO;
import com.microfinancasapi.model.Parcela;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ParcelaMapper {

    @Mapping(target = "emprestimo", ignore = true)
    Parcela toEntity(ParcelaRequestDTO dto);

    @Mapping(target = "emprestimoId", source = "emprestimo.id")
    ParcelaResponseDTO toResponseDTO(Parcela entity);
}
