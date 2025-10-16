package com.apimongo.converter;

import com.apimongo.dto.RegistroParadaRequestDTO;
import com.apimongo.model.RegistroParadas;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Converter {
    public RegistroParadas paraRegistroParadas(RegistroParadaRequestDTO dto){
        return RegistroParadas.builder()
                .id_maquina(dto.getId_maquina())
                .id_usuario(dto.getId_usuario())
                .date(dto.getDate())
                .descricao(dto.getDescricao())
                .build();
    }


}
