package com.apimongo.dto;

public class RegistroParadaRequestDTO {
    private Integer id_maquina;
    private Integer id_usuario;
    private String date;
    private String descricao;

    public RegistroParadaRequestDTO(
            Integer id_maquina,
            Integer id_usuario,
            String date,
            String descricao) {

        this.id_maquina = id_maquina;
        this.id_usuario = id_usuario;
        this.date = date;
        this.descricao = descricao;
    }

    public RegistroParadaRequestDTO(){}

    public Integer getId_maquina() {
        return id_maquina;
    }

    public void setId_maquina(Integer id_maquina) {
        this.id_maquina = id_maquina;
    }

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
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
