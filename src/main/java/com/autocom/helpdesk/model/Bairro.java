package com.autocom.helpdesk.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Bairro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull (message = "O nome do bairro nao pode estar vazio")
    @Size( min = 5 , message = "o nome precisa ter mais de 5 caracteres")
    private String nomeBairro;

    @OneToMany(mappedBy = "bairro")
    private List<Visita> visitas = new ArrayList<>();


    public Bairro(){}

    public Bairro(Integer id, String nomeBairro, List<Visita> visitas) {
        this.id = id;
        this.nomeBairro = nomeBairro;
        this.visitas = visitas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeBairro() {
        return nomeBairro;
    }

    public void setNomeBairro(String nomeBairro) {
        this.nomeBairro = nomeBairro;
    }

    public List<Visita> getVisitas() {
        return visitas;
    }

    public void setVisitas(List<Visita> visitas) {
        this.visitas = visitas;
    }
}
