package com.example.iformal.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Representa um agendamento de serviço no sistema.
 * 
 * Esta classe é uma entidade persistente mapeada para a tabela "agendamentos"
 * no banco de dados.
 * Armazena informações como o usuário associado, o serviço agendado, a data do
 * serviço, observações e o preço.
 * 
 * <p>
 * <strong>Anotações do Spring:</strong>
 * </p>
 * <ul>
 * <li>{@code @Entity}: Indica que a classe é uma entidade persistente,
 * permitindo o mapeamento no banco de dados.</li>
 * <li>{@code @Table(name = "servicos")}: Especifica o nome da tabela no banco
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
 * Agendamentos agendamento = new Agendamentos();
 * agendamento.setUsuario(usuario);
 * agendamento.setServico(servico);
 * agendamento.setData_servico(LocalDate.now());
 * agendamento.setObservacao("Observações sobre o serviço.");
 * agendamento.setPreco(100.0f);
 * agendamentoService.salvar(agendamento);
 * }
 * </pre>
 * 
 * @author Squad 44 - Ilnara Ackermann
 */
@Entity
@Table(name = "agendamentos")
public class Agendamentos {
    /**
     * Chave primária que identifica exclusivamente cada agendamento no sistema.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_agendamento")
    private int id;

    /**
     * Usuário associado ao agendamento.
     */
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    /**
     * Serviço agendado.
     */
    @ManyToOne
    @JoinColumn(name = "id_servico")
    private Servicos servico;

    /**
     * Data do serviço agendado.
     */
    @DateTimeFormat(iso = ISO.DATE)
    private LocalDate data_servico;

    /**
     * Observações adicionais sobre o serviço agendado.
     */

    @Column(name = "observacoes", columnDefinition = "TEXT")
    private String observacao;

    /**
     * Preço do serviço agendado.
     */
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

    public LocalDate getData_servico() {
        return data_servico;
    }

    public void setData_servico(LocalDate data_servico) {
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