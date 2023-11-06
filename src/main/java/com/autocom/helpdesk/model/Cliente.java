package com.autocom.helpdesk.model;

import com.autocom.helpdesk.enums.Perfil;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cliente extends Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;

    @OneToMany(mappedBy = "cliente")
    public List<Chamado> chamados = new ArrayList<>();

    public Cliente(List<Chamado> chamados) {
        this.chamados = chamados;
    }

    public Cliente() {}

    public Cliente(Integer id, String nome, String email, String senha, String imagem, Perfil perfil, List<Chamado> chamados) {
        super(id, nome, email, senha, imagem, perfil);
    }

    public List<Chamado> getChamados() {
        return chamados;
    }

    public void setChamados(List<Chamado> chamados) {
        this.chamados = chamados;
    }
}
