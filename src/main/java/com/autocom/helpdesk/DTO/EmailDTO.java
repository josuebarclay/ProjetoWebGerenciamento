package com.autocom.helpdesk.DTO;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

public class EmailDTO {


    private String ownrRef; //referencia do propetario enviado
    private String emailFrom; //quem esta enviando
    private String emailTo; //pra quem esta sendo enviado
    private String subject; //titulo do email
    private String text;

    public EmailDTO(){}

    public EmailDTO(String ownrRef, String emailFrom, String emailTo, String subject, String text) {
        this.ownrRef = ownrRef;
        this.emailFrom = emailFrom;
        this.emailTo = emailTo;
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

    public String getEmailTo() {
        return emailTo;
    }

    public void setEmailTo(String emailTo) {
        this.emailTo = emailTo;
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
