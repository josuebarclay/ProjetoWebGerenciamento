package com.autocom.helpdesk.enums;

public enum TipoSistema {

    NFE("NF-e"),
    NFCE("NFC-e"),
    MDFE("MDF-e"),
    MOBILE("Mobile"),
    DELIVERY("Delivery"),
    PDV("PDV");

    private String TipoSistema;

    private TipoSistema(String tipoSistema){
        this.TipoSistema = tipoSistema;
    }

    public String getTipoSistema() {
        return TipoSistema;
    }

    public void setTipoSistema(String tipoSistema) {
        TipoSistema = tipoSistema;
    }
}
