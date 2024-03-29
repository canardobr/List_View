package com.example.listview.modelos;

public class Tarefa {

    // Atributos da classe
    private String id;
    private String nome;
    private String descricao;
    private Boolean status;

    public Tarefa(String id, String nome, String descricao, Boolean status) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.status = status;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
