package com.autocom.helpdesk.model;

import com.autocom.helpdesk.enums.Perfil;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Tecnico extends Pessoa{
    private static final long serialVersionUID = 1L;

    @OneToMany(mappedBy = "tecnico")
    public List<Chamado> chamados = new ArrayList<>();

    public Tecnico(List<Chamado> chamados) {
        this.chamados = chamados;
    }

    public Tecnico(Integer id, String nome, String email, String senha, String imagem, Perfil perfil, List<Chamado> chamados) {
        super(id, nome, email, senha, imagem, perfil);
    }
    public Tecnico() {}



    public List<Chamado> getChamados() {
        return chamados;
    }

    public void setChamados(List<Chamado> chamados) {
        this.chamados = chamados;
    }
}
