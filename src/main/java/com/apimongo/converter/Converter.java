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
                .nomeMaquina(dto.getNomeMaquina())
                .id_usuario(dto.getId_usuario())
                .setor(dto.getSetor())
                .descricao(dto.getDescricao())
                .date(dto.getDate())
                .build();
    }


}
