package com.autocom.helpdesk.DTO;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

public class EmailDTO {

    @NotBlank
    private String ownrRef; //referencia do propetario enviado
    @NotBlank
    private String emailFrom; //quem esta enviando
    @NotBlank
    private String telefone; //pra quem esta sendo enviado
    @NotBlank
    private String subject; //titulo do email
    @NotBlank
    private String text;

    public EmailDTO(){}

    public EmailDTO(String ownrRef, String emailFrom, String telefone, String subject, String text) {
        this.ownrRef = ownrRef;
        this.emailFrom = emailFrom;
        this.telefone = telefone;
        this.subject = subject;
        this.text = text;
    }

    public String getOwnrRef() {
        return ownrRef;
    }

    public void setOwnrRef(String ownrRef) {
        this.ownrRef = ownrRef;
    }

    public String getEmailFrom() {
        return emailFrom;
    }

    public void setEmailFrom(String emailFrom) {
        this.emailFrom = emailFrom;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
