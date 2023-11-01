package com.autocom.helpdesk.model;


import javax.validation.constraints.NotNull;

public class ResetPasswordUserDao {

    @NotNull
    private String senhaAtual;
    @NotNull
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
