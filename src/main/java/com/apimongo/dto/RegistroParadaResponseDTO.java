package com.apimongo.dto;

public class RegistroParadaResponseDTO {
    private String id;
    private Integer id_maquina;
    private String nomeMaquina;
    private Integer id_usuario;
    private String setor;
    private String descricao;
    private String date;

    public RegistroParadaResponseDTO(
            Integer id_maquina,
            String nomeMaquina,
            Integer id_usuario,
            String setor,
            String descricao,
            String date) {

        this.id_maquina = id_maquina;
        this.nomeMaquina = nomeMaquina;
        this.id_usuario = id_usuario;
        this.setor = setor;
        this.descricao = descricao;
        this.date = date;
    }

    public RegistroParadaResponseDTO(){}

    public String getId() {
        return id;
    }

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

    public String getNomeMaquina(){ return nomeMaquina;}

    public void setNomeMaquina(String nomeMaquina){ this.nomeMaquina = nomeMaquina; }

    public String getSetor(){ return setor;}

    public void setSetor(String setor){this.setor = setor;}

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
