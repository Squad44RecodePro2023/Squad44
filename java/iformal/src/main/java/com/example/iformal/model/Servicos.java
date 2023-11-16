package com.example.iformal.model;
/**
 * Representa um serviço oferecido pelo sistema.
 * 
 * Esta classe modela os serviços disponíveis para agendamento, contendo informações
 * como nome e descrição.
 */
public class Servicos {

    private int id;
    private String nome;
    private String descricao;

    /**
     * Obtém o ID do serviço.
     * 
     * @return O ID do serviço.
     */
    public int getId() {
        return id;
    }

    /**
     * Define o ID do serviço.
     * 
     * @param id O novo ID do serviço.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtém o nome do serviço.
     * 
     * @return O nome do serviço.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do serviço.
     * 
     * @param nome O novo nome do serviço.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém a descrição do serviço.
     * 
     * @return A descrição do serviço.
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Define a descrição do serviço.
     * 
     * @param descricao A nova descrição do serviço.
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "Servicos [id=" + id + ", nome=" + nome + ", descricao=" + descricao + "]";
    }

}
