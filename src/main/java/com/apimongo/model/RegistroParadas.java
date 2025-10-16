package com.apimongo.model;

import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Document(collection = "registro_paradas")
public class RegistroParadas {
    @Id
    private String id;
    private String id_maquina;
    private String id_usuario;
    private String date;
    private String descricao;

    public RegistroParadas(
            String id,
            String id_maquina,
            String id_usuario,
            String date,
            String descricao) {

        this.id = id;
        this.id_maquina = id_maquina;
        this.id_usuario = id_usuario;
        this.date = date;
        this.descricao = descricao;
    }

    public RegistroParadas(){}

    public String getId() {
        return id;
    }

    public String getId_maquina() {
        return id_maquina;
    }

    public void setId_maquina(String id_maquina) {
        this.id_maquina = id_maquina;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
