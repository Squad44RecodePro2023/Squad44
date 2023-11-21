package com.example.iformal.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Representa um usuário do sistema.
 * 
 * Esta classe é uma entidade persistente mapeada para a tabela "usuarios" no
 * banco de dados.
 * Armazena informações como nome, email, CPF, contato e senha.
 * 
 * <p>
 * <strong>Anotações:</strong>
 * </p>
 * <ul>
 * <li>{@code @Entity}: Indica que a classe é uma entidade persistente,
 * permitindo o mapeamento no banco de dados.</li>
 * <li>{@code @Table(name = "usuarios")}: Especifica o nome da tabela no banco
 * de dados. Caso esta anotação seja omitida, o Spring usará o nome da classe
 * como o nome da tabela por padrão.</li>
 * <li>{@code @Id}: Indica que o campo a seguir é a chave primária da
 * entidade.</li>
 * <li>{@code @GeneratedValue(strategy = GenerationType.IDENTITY)}: Especifica
 * que o valor da chave primária será gerado automaticamente pelo banco de dados
 * (geralmente usado com colunas de autoincremento).</li>
 * <li>{@code @Column(nullable = false)}: Indica que o campo não pode ser nulo
 * no banco de dados.</li>
 * </ul>
 * 
 * <p>
 * <strong>Exemplo de uso:</strong>
 * </p>
 * 
 * <pre>
 * {@code
 * Usuario usuario = new Usuario("John Doe", "john@example.com", "123.456.789-01", "123-4567", "senha123");
 * usuarioService.salvar(usuario);
 * }
 * </pre>
 * 
 * @author Squad 44 - Ilnara Ackermann
 */
@Entity
@Table(name = "usuarios")
public class Usuario {

    /**
     * Chave primária que identifica exclusivamente cada usuário no sistema.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private int id;

    /**
     * Nome do usuário.
     */
    @Column(nullable = false)
    private String nome;

    /**
     * Endereço de email do usuário.
     */
    @Column(nullable = false)
    private String email;

    /**
     * Número do CPF do usuário.
     */
    @Column(nullable = false)
    private String cpf;

    /**
     * Número de contato do usuário.
     */
    @Column(nullable = false)
    private String contato;

    /**
     * Senha do usuário.
     */
    @Column(nullable = false)
    private String senha;

    /**
     * Construtor padrão.
     */
    public Usuario() {
    }

    /**
     * Construtor para criar um objeto {@code Usuario} com informações específicas.
     * 
     * @param nome    O nome do usuário.
     * @param email   O endereço de email do usuário.
     * @param cpf     O CPF do usuário.
     * @param contato O número de contato do usuário.
     * @param senha   A senha do usuário.
     */
    public Usuario(String nome, String email, String cpf, String contato, String senha) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.contato = contato;
        this.senha = senha;
    }

    /**
     * Obtém o ID do usuário.
     * 
     * @return O ID do usuário.
     */
    public int getId() {
        return id;
    }

    /**
     * Define o ID do usuário.
     * 
     * @param id O novo ID do usuário.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtém o nome do usuário.
     * 
     * @return O nome do usuário.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do usuário.
     * 
     * @param nome O novo nome do usuário.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém o endereço de email do usuário.
     * 
     * @return O endereço de email do usuário.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Define o endereço de email do usuário.
     * 
     * @param email O novo endereço de email do usuário.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Obtém o CPF do usuário.
     * 
     * @return O CPF do usuário.
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * Define o CPF do usuário.
     * 
     * @param cpf O novo CPF do usuário.
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * Obtém o número de contato do usuário.
     * 
     * @return O número de contato do usuário.
     */
    public String getContato() {
        return contato;
    }

    /**
     * Define o número de contato do usuário.
     * 
     * @param contato O novo número de contato do usuário.
     */
    public void setContato(String contato) {
        this.contato = contato;
    }

    /**
     * Obtém a senha do usuário.
     * 
     * @return A senha do usuário.
     */
    public String getSenha() {
        return senha;
    }

    /**
     * Define a senha do usuário.
     * 
     * @param senha A nova senha do usuário.
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "Usuario [id=" + id + ", nome=" + nome + ", email=" + email + ", cpf=" + cpf + ", contato=" + contato
                + "]";
    };
};