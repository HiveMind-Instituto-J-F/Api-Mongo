package com.apimongo.dto;

public class RegistroParadaRequestDTO {
    private String id_maquina;
    private String id_usuario;
    private String date;
    private String descricao;

    public RegistroParadaRequestDTO(
            String id_maquina,
            String id_usuario,
            String date,
            String descricao) {

        this.id_maquina = id_maquina;
        this.id_usuario = id_usuario;
        this.date = date;
        this.descricao = descricao;
    }

    public RegistroParadaRequestDTO(){}

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
