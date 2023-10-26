package com.autocom.helpdesk.enums;

public enum StatusVisita {

        RETORNO("Precisa retornar"),
        ANDAMENTO("Em Andamento"),
        FECHADO("Fechou Venda ");


        private String visitaStatus;

    StatusVisita(String visitaStatus) {
        this.visitaStatus = visitaStatus;
    }

    public String getVisitaStatus() {
        return visitaStatus;
    }

    public void setVisitaStatus(String visitaStatus) {
        this.visitaStatus = visitaStatus;
    }
}
