package com.apimongo.controller;

import com.apimongo.dto.RegistroParadaRequestDTO;
import com.apimongo.dto.RegistroParadaResponseDTO;
import com.apimongo.model.RegistroParadas;
import com.apimongo.service.RegistroParadasService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api-mongo")
public class RegistroParadasController {
    private final RegistroParadasService service;
    private final ObjectMapper objectMapper;

    public RegistroParadasController (RegistroParadasService service, ObjectMapper objectMapper){
        this.service = service;
        this.objectMapper = objectMapper;
    }

    @GetMapping("/selecionar")
    public List<RegistroParadaResponseDTO> selecionar(){
        return service.selecionar();
    }


    @GetMapping("/buscar/{id}")
    public RegistroParadas buscarId(@PathVariable Integer id){
        return service.buscarRegistroPorId(id);
    }

    @PostMapping("/inserir")
    public String save (@RequestBody RegistroParadaRequestDTO dto) throws JsonProcessingException {
        RegistroParadaResponseDTO resposta = service.save(dto);
        return "O registro foi inserido, com ID: " + resposta.getId() + ", com sucesso!";
    }

    @PutMapping("/atualizar/{id}")
    public String update(@PathVariable Integer id, @RequestBody RegistroParadaRequestDTO dto){
        RegistroParadaResponseDTO resposta = service.update(id, dto);
        return "O registro com ID: " + resposta.getId() + ", foi atualizado com sucesso!";
    }

    @PatchMapping("/atualizarParcialmente/{id}")
    public String updatePartially (@PathVariable Integer id, @RequestBody RegistroParadaRequestDTO dto) {
        System.out.println("Id: " + id);
        System.out.println("Descricao: " + dto.getDescricao());
        RegistroParadaResponseDTO responseDTO = service.updatePartially(id, dto);
        return "O registro, com ID: " + responseDTO.getId() + ", foi atualizado com sucesso!";
    }

    @DeleteMapping("/deletar/{id}")
    public String delete(@PathVariable ObjectId id){
        RegistroParadaResponseDTO resposta = service.delete(id);
        return "O registro, com ID: " + resposta.getId() + ", foi excluido com sucesso!";
    }

}
