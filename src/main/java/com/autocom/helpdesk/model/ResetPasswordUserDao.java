package com.autocom.helpdesk.model;


public class ResetPasswordUserDao {

    private String senhaAtual;

    private String novaSenha;

    public ResetPasswordUserDao() {}

    public ResetPasswordUserDao(String senhaAtual) {
        this.senhaAtual = senhaAtual;
    }



    public String getSenhaAtual() {
        return senhaAtual;
    }

    public void setSenhaAtual(String senhaAtual) {
        this.senhaAtual = senhaAtual;
    }

    public String getNovaSenha() {
        return novaSenha;
    }

    public void setNovaSenha(String novaSenha) {
        this.novaSenha = novaSenha;
    }
}
