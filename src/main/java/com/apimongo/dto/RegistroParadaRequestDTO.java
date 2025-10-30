package com.apimongo.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Date;

public class RegistroParadaRequestDTO {
    @NotNull(message = "O campo id_maquina está vazio. Preenche-o")
    private Integer id_maquina;

    @NotNull(message = "O campo id_usuario está vazio. Preenche-o")
    private Integer id_usuario;

    @NotBlank(message = "O campo des_parada está vazio. Preenche-o")
    private String des_parada;

    @NotBlank(message = "O campo des_setor está vazio. Preenche-o")
    @Size(max = 50, message = "A descrição deve conter no máximo 50 caracteres")
    private String des_setor;

    @NotNull(message = "O campo dt_parada está vazio. Preenche-o")
    private Date dt_parada;

    @NotNull(message = "O campo hora_Fim está vazio. Preenche-o")
    private Date hora_Fim;

    @NotNull(message = "O campo hora_Inicio está vazio. Preenche-o")
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