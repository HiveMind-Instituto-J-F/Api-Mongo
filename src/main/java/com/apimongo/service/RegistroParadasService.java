package com.apimongo.service;

import com.apimongo.converter.RegistroParadaMapper;
import com.apimongo.dto.RegistroParadaRequestDTO;
import com.apimongo.dto.RegistroParadaResponseDTO;
import com.apimongo.model.RegistroParadas;
import com.apimongo.repository.RegistroParadasRepository;
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

    public RegistroParadas buscarRegistroPorId(String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        return mongoTemplate.findOne(query, RegistroParadas.class);
    }

    public RegistroParadaResponseDTO save(RegistroParadaRequestDTO dtoRequest){
        RegistroParadas rp = objectMapper.convertValue(dtoRequest, RegistroParadas.class);
        rp = registroParadasRepository.save(rp);
        return objectMapper.convertValue(rp, RegistroParadaResponseDTO.class);
    }

    public RegistroParadaResponseDTO update(String id, RegistroParadaRequestDTO dtoRequest){
        RegistroParadas registroExistente = buscarRegistroPorId(id);

        registroExistente.setId_maquina(dtoRequest.getId_maquina());
        registroExistente.setId_usuario(dtoRequest.getId_usuario());
        registroExistente.setDate(dtoRequest.getDate());
        registroExistente.setDescricao(dtoRequest.getDescricao());

        RegistroParadas regitro = registroParadasRepository.save(registroExistente);
        return objectMapper.convertValue(regitro, RegistroParadaResponseDTO.class);
    }

    public RegistroParadaResponseDTO updatePartially(String id, RegistroParadaRequestDTO dto) {
        RegistroParadas registroExistente = buscarRegistroPorId(id);

        System.out.println(registroExistente.getDescricao());

        if (dto.getId_maquina() != null){
            registroExistente.setId_maquina(dto.getId_maquina());
            System.out.println(registroExistente.getId_maquina());
        }

        if (dto.getId_usuario() != null){
            registroExistente.setId_usuario(dto.getId_usuario());
            System.out.println(registroExistente.getId_usuario());
        }

        if (dto.getDate() != null){
            registroExistente.setDate(dto.getDate());
            System.out.println(registroExistente.getDate());
        }

        if (dto.getDescricao() != null){
            registroExistente.setDescricao(dto.getDescricao());
            System.out.println(registroExistente.getDescricao());
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
