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
                .des_parada(dto.getDes_parada())
                .des_setor(dto.getDes_setor())
                .dt_parada(dto.getDt_parada())
                .hora_Fim(dto.getHora_Fim())
                .hora_Inicio(dto.getHora_Inicio())
                .build();
    }
}