package com.example.iformal.model;
public class Agendamentos {
    private int id;
    private Usuario usuario;
    private Servicos servico;
    private String data_servico;
    private String observacao;
    private float preco;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public Servicos getServico() {
        return servico;
    }
    public void setServico(Servicos servico) {
        this.servico = servico;
    }
    public String getData_servico() {
        return data_servico;
    }
    public void setData_servico(String data_servico) {
        this.data_servico = data_servico;
    }
    public String getObservacao() {
        return observacao;
    }
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    public float getPreco() {
        return preco;
    }
    public void setPreco(float preco) {
        this.preco = preco;
    }
    @Override
    public String toString() {
        return "Agendamentos [id=" + id + ", usuario=" + usuario + ", servico=" + servico + ", data_servico="
                + data_servico + ", observacao=" + observacao + ", preco=" + preco + "]";
    }


}