package com.autocom.helpdesk.enums;

public enum SimNao {
    SIM("Sim"),
    NAO("Não");

    private String sim;

    private SimNao(String sim) {
        this.sim = sim;
    }

    public String getSim() {
        return sim;
    }
}

