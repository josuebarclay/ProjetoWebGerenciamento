package com.autocom.helpdesk.enums;

public enum Perfil {

    ADMIN("ADMINISTRADOR"),
    TECNICO("TECNICO"),
    CLIENTE("CLIENTE");

    private String perfil;

    private Perfil(String perfil){
        this.perfil = perfil;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }
}
