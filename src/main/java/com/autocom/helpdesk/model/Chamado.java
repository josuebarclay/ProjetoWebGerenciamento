package com.autocom.helpdesk.model;

import com.autocom.helpdesk.enums.Prioridade;
import com.autocom.helpdesk.enums.StatusTicket;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
public class Chamado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titulo;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataAbertura = LocalDate.now();
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataFechamento;

    @NotNull(message = "O nome do bairro nao pode estar vazio")
    @Size( min = 10 , message = "o nome precisa ter mais de 5 caracteres")
    @Column(length = 500)
    private String observacao;

    private Prioridade prioridade;
    private StatusTicket status;

    @ManyToOne //varios chamados p um cliente
    @JoinColumn(name = "cliente_id_fk")
    private Cliente cliente;

    @ManyToOne //varios chamados p um tecnico
    @JoinColumn(name = "tecnico_id_fk")
    private Tecnico tecnico;


    public Chamado(){}

    public Chamado(Integer id, String titulo, LocalDate dataAbertura, LocalDate dataFechamento, String observacao, Prioridade prioridade, StatusTicket statusTicket) {
        this.id = id;
        this.titulo = titulo;
        this.dataAbertura = dataAbertura;
        this.dataFechamento = dataFechamento;
        this.observacao = observacao;
        this.prioridade = prioridade;
        this.status = statusTicket;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDate getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDate dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public LocalDate getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(LocalDate dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    public StatusTicket getStatus() {
        return status;
    }

    public void setStatus(StatusTicket statusTicket) {
        this.status = statusTicket;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Tecnico getTecnico() {
        return tecnico;
    }

    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }


    @Override
    public String toString() {
        return "Chamado{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", dataAbertura=" + dataAbertura +
                ", dataFechamento=" + dataFechamento +
                ", observacao='" + observacao + '\'' +
                ", prioridade=" + prioridade +
                ", status=" + status +
                ", cliente=" + cliente +
                ", tecnico=" + tecnico +
                '}';
    }
}



