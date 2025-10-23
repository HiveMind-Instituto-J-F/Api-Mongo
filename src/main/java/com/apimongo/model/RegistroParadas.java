package com.apimongo.model;

import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Document(collection = "registro_paradas")
public class RegistroParadas {
    @Id
    private String id;
    private Integer id_maquina;
    private String nomeMaquina;
    private Integer id_usuario;
    private String setor;
    private String descricao;
    private String date;

    public RegistroParadas() {
    }

    public RegistroParadas(String id, Integer id_maquina, String nomeMaquina, Integer id_usuario, String setor, String descricao, String date) {
        this.id = id;
        this.id_maquina = id_maquina;
        this.nomeMaquina = nomeMaquina;
        this.id_usuario = id_usuario;
        this.setor = setor;
        this.descricao = descricao;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getId_maquina() {
        return id_maquina;
    }

    public void setId_maquina(Integer id_maquina) {
        this.id_maquina = id_maquina;
    }

    public String getNomeMaquina() {
        return nomeMaquina;
    }

    public void setNomeMaquina(String nomeMaquina) {
        this.nomeMaquina = nomeMaquina;
    }

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
