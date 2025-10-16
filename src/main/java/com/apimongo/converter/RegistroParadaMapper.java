package com.apimongo.converter;

import com.apimongo.dto.RegistroParadaResponseDTO;
import com.apimongo.model.RegistroParadas;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface RegistroParadaMapper {

    RegistroParadaResponseDTO paraRegistroParadaResponseDTO(RegistroParadas rp);

}
