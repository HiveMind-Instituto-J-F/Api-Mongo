
package com.apimongo.service;

import com.apimongo.converter.RegistroParadaMapper;
import com.apimongo.dto.RegistroParadaRequestDTO;
import com.apimongo.dto.RegistroParadaResponseDTO;
import com.apimongo.model.RegistroParadas;
import com.apimongo.repository.RegistroParadasRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RegistroParadasService {

    private final RegistroParadasRepository registroParadasRepository;
    private final RegistroParadaMapper mapper;
    private final ObjectMapper objectMapper;
    private final MongoTemplate mongoTemplate;

    public RegistroParadasService(
            RegistroParadasRepository registroParadasRepository,
            ObjectMapper objectMapper,
            RegistroParadaMapper mapper,
            MongoTemplate mongoTemplate
    )
    {
        this.registroParadasRepository = registroParadasRepository;
        this.objectMapper = objectMapper;
        this.mapper = mapper;
        this.mongoTemplate = mongoTemplate;
    }

    public List<RegistroParadaResponseDTO> selecionar(){
        List<RegistroParadas> rp = registroParadasRepository.findAll();
        List<RegistroParadaResponseDTO> rdto = new ArrayList<>();
        for (RegistroParadas rp1 : rp){
            rdto.add(mapper.paraRegistroParadaResponseDTO(rp1));
        }
        return rdto;
    }

    public RegistroParadas buscarRegistroPorId(Integer id) {
        Query query = new Query(Criteria.where("_id").is(id));
        return mongoTemplate.findOne(query, RegistroParadas.class);
    }

    public RegistroParadaResponseDTO save(RegistroParadaRequestDTO dtoRequest) throws JsonProcessingException {
        RegistroParadas rp = objectMapper.convertValue(dtoRequest, RegistroParadas.class);
        System.out.println("DTO recebido: " + objectMapper.writeValueAsString(dtoRequest));
        rp = registroParadasRepository.save(rp);
        return objectMapper.convertValue(rp, RegistroParadaResponseDTO.class);
    }

    public RegistroParadaResponseDTO update(Integer id, RegistroParadaRequestDTO dtoRequest){
        RegistroParadas registroExistente = buscarRegistroPorId(id);

        registroExistente.setId_maquina(dtoRequest.getId_maquina());
        registroExistente.setId_usuario(dtoRequest.getId_usuario());
        registroExistente.setDes_parada(dtoRequest.getDes_parada());
        registroExistente.setDes_setor(dtoRequest.getDes_setor());
        registroExistente.setDt_parada(dtoRequest.getDt_parada());
        registroExistente.setHora_Fim(dtoRequest.getHora_Fim());
        registroExistente.setHora_Inicio(dtoRequest.getHora_Inicio());

        RegistroParadas regitro = registroParadasRepository.save(registroExistente);
        return objectMapper.convertValue(regitro, RegistroParadaResponseDTO.class);
    }

    public RegistroParadaResponseDTO updatePartially(Integer id, RegistroParadaRequestDTO dto) {
        RegistroParadas registroExistente = buscarRegistroPorId(id);

        System.out.println("Descricao: " + dto.getDes_parada());

        if (dto.getId_maquina() != null){
            registroExistente.setId_maquina(dto.getId_maquina());
        }

        if (dto.getId_usuario() != null){
            registroExistente.setId_usuario(dto.getId_usuario());
        }

        if (dto.getDes_parada() != null){
            registroExistente.setDes_parada(dto.getDes_parada());
        }

        if (dto.getDes_setor() != null){
            registroExistente.setDes_setor(dto.getDes_setor());
        }

        if (dto.getDt_parada() != null){
            registroExistente.setDt_parada(dto.getDt_parada());
        }

        if (dto.getHora_Fim() != null){
            registroExistente.setHora_Fim(dto.getHora_Fim());
        }

        if (dto.getHora_Inicio() != null){
            registroExistente.setHora_Inicio(dto.getHora_Inicio());
        }

        RegistroParadas registro = registroParadasRepository.save(registroExistente);
        return objectMapper.convertValue(registro, RegistroParadaResponseDTO.class);
    }

    public RegistroParadaResponseDTO delete(ObjectId id){
        Optional<RegistroParadas> rpExistente = registroParadasRepository.findById(id);
        RegistroParadas registroExistente = objectMapper.convertValue(rpExistente, RegistroParadas.class);
        registroParadasRepository.deleteById(id);
        return objectMapper.convertValue(registroExistente, RegistroParadaResponseDTO.class);
    }
}