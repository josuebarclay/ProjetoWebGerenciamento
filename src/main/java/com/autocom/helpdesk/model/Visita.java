package com.autocom.helpdesk.model;

import com.autocom.helpdesk.enums.SimNao;
import com.autocom.helpdesk.enums.StatusVisita;
import com.autocom.helpdesk.enums.TipoSistema;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Entity
public class Visita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "CAMPO OBRIGATORIO")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataVisita = LocalDate.now();

    @NotBlank(message = "CAMPO OBRIGATORIO")
    private String nomeVisitante;

    @NotBlank(message = "CAMPO OBRIGATORIO")
    private String nomeEmpresa;

    @NotBlank(message = "CAMPO OBRIGATORIO")
    private String endereco;

    @NotBlank(message = "CAMPO OBRIGATORIO")
    private String contato;

    @Pattern(regexp = "^[0-9\\s]+$", message = "O telefone deve conter apenas dígitos e espaços")
    private String telefone;

    @Email(message = "Informe um endereço de e-mail válido")
    private String email;

    @NotNull(message = "CAMPO OBRIGATORIO")
    private String informacao; //Descreva a visita em detalhes, incluindo o que aconteceu durante a reunião. Isso pode envolver discussões sobre produtos, serviços, preços, termos contratuais, resolução de problemas ou qualquer outra interação significativa.

    @NotNull(message = "CAMPO OBRIGATORIO")
    private SimNao temSistema;
    private String motivo;
    private String nomeEmpresaAutomacao;

    @NotNull(message = "CAMPO OBRIGATORIO")
    private TipoSistema tipoSistema;
    private String tempodoSistema;
    private SimNao satisfacao; //satisfeito com o sistema
    private SimNao suporte; //satisfeito com o suporte
    private SimNao cartao;
    private String recebimento; //qual o tipo do recebimento


    private LocalDate dataRetorno30Dias = LocalDate.now();
    private StatusVisita statusVisita ;

    @ManyToOne
    @JoinColumn(name = "bairro_id_fk") // O nome da coluna deve corresponder ao nome da coluna na tabela do banco de dados
    private Bairro bairro;

    public Visita(){}

    public Visita(Integer id, LocalDate dataVisita, String nomeVisitante, String nomeEmpresa, String endereco, String contato, String telefone, String email, String informacao, SimNao temSistema, String motivo, String nomeEmpresaAutomacao, TipoSistema tipoSistema, String tempodoSistema, SimNao satisfacao, SimNao suporte, SimNao cartao, String recebimento, LocalDate dataRetorno30Dias, StatusVisita statusVisita, Bairro bairro) {
        this.id = id;
        this.dataVisita = dataVisita;
        this.nomeVisitante = nomeVisitante;
        this.nomeEmpresa = nomeEmpresa;
        this.endereco = endereco;
        this.contato = contato;
        this.telefone = telefone;
        this.email = email;
        this.informacao = informacao;
        this.temSistema = temSistema;
        this.motivo = motivo;
        this.nomeEmpresaAutomacao = nomeEmpresaAutomacao;
        this.tipoSistema = tipoSistema;
        this.tempodoSistema = tempodoSistema;
        this.satisfacao = satisfacao;
        this.suporte = suporte;
        this.cartao = cartao;
        this.recebimento = recebimento;
        this.dataRetorno30Dias = dataRetorno30Dias;
        this.statusVisita = statusVisita;
        this.bairro = bairro;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDataVisita() {
        return dataVisita;
    }

    public void setDataVisita(LocalDate dataVisita) {
        this.dataVisita = dataVisita;
    }

    public String getNomeVisitante() {
        return nomeVisitante;
    }

    public void setNomeVisitante(String nomeVisitante) {
        this.nomeVisitante = nomeVisitante;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInformacao() {
        return informacao;
    }

    public void setInformacao(String informacao) {
        this.informacao = informacao;
    }

    public SimNao getTemSistema() {
        return temSistema;
    }

    public void setTemSistema(SimNao temSistema) {
        this.temSistema = temSistema;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getNomeEmpresaAutomacao() {
        return nomeEmpresaAutomacao;
    }

    public void setNomeEmpresaAutomacao(String nomeEmpresaAutomacao) {
        this.nomeEmpresaAutomacao = nomeEmpresaAutomacao;
    }

    public TipoSistema getTipoSistema() {
        return tipoSistema;
    }

    public void setTipoSistema(TipoSistema tipoSistema) {
        this.tipoSistema = tipoSistema;
    }

    public String getTempodoSistema() {
        return tempodoSistema;
    }

    public void setTempodoSistema(String tempodoSistema) {
        this.tempodoSistema = tempodoSistema;
    }

    public SimNao getSatisfacao() {
        return satisfacao;
    }

    public void setSatisfacao(SimNao satisfacao) {
        this.satisfacao = satisfacao;
    }

    public SimNao getSuporte() {
        return suporte;
    }

    public void setSuporte(SimNao suporte) {
        this.suporte = suporte;
    }

    public SimNao getCartao() {
        return cartao;
    }

    public void setCartao(SimNao cartao) {
        this.cartao = cartao;
    }

    public String getRecebimento() {
        return recebimento;
    }

    public void setRecebimento(String recebimento) {
        this.recebimento = recebimento;
    }

    public StatusVisita getStatusVisita() {
        return statusVisita;
    }

    public void setStatusVisita(StatusVisita statusVisita) {
        this.statusVisita = statusVisita;
    }

    public Bairro getBairro() {
        return bairro;
    }

    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }

    public LocalDate getDataRetorno30Dias() {
        return dataRetorno30Dias;
    }

    public void setDataRetorno30Dias(LocalDate dataRetorno30Dias) {
        this.dataRetorno30Dias = dataRetorno30Dias;
    }
}



