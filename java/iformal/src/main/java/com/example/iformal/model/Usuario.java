package com.example.iformal.model;

public class Usuario {

    private int id;
    private String nome;
    private String email;
    private String cpf;
    private String contato;
    private String senha;

    public Usuario() {
    }

    public Usuario(String nome, String email, String cpf, String contato, String senha) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.contato = contato;
        this.senha = senha;
    }

    public int getId() {
        return id;
    }

    public void setId_usuario(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Usuario [id=" + id + ", nome=" + nome + ", email=" + email + ", cpf=" + cpf + ", contato=" + contato
                + "]";
    }

}