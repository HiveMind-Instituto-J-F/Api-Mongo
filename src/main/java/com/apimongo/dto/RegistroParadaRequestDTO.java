package com.apimongo.dto;

import java.util.Date;

public class RegistroParadaRequestDTO {
    private Integer id_maquina;
    private Integer id_usuario;
    private String des_parada;
    private String des_setor;
    private Date dt_parada;
    private Date hora_Fim;
    private Date hora_Inicio;

    public RegistroParadaRequestDTO(
            Integer id_maquina,
            Integer id_usuario,
            String des_parada,
            String des_setor,
            Date dt_parada,
            Date hora_Fim,
            Date hora_Inicio)
    {
        this.id_maquina = id_maquina;
        this.id_usuario = id_usuario;
        this.des_parada = des_parada;
        this.des_setor = des_setor;
        this.dt_parada = dt_parada;
        this.hora_Fim = hora_Fim;
        this.hora_Inicio = hora_Inicio;
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

    public String getDes_parada() {
        return des_parada;
    }

    public void setDes_parada(String des_parada) {
        this.des_parada = des_parada;
    }

    public String getDes_setor() {
        return des_setor;
    }

    public void setDes_setor(String des_setor) {
        this.des_setor = des_setor;
    }

    public Date getDt_parada() {
        return dt_parada;
    }

    public void setDt_parada(Date dt_parada) {
        this.dt_parada = dt_parada;
    }

    public Date getHora_Fim() {
        return hora_Fim;
    }

    public void setHora_Fim(Date hora_Fim) {
        this.hora_Fim = hora_Fim;
    }

    public Date getHora_Inicio() {
        return hora_Inicio;
    }

    public void setHora_Inicio(Date hora_Inicio) {
        this.hora_Inicio = hora_Inicio;
    }
}