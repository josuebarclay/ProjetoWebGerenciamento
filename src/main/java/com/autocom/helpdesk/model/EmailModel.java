package com.autocom.helpdesk.model;

import com.autocom.helpdesk.enums.StatusEmail;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class EmailModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long emailId;
    private String ownrRef; //referencia do propetario enviado
    private String emailFrom; //quem esta enviando
    private String emailTo; //pra quem esta sendo enviado
    private String subject; //titulo do email
    @Column(columnDefinition = "TEXT") // corpo do email
    private String text;
    private LocalDate sendDateEmail;
    private StatusEmail statusEmail;

    public EmailModel(){}

    public EmailModel(Long emailId, String ownrRef, String emailFrom, String emailTo, String subject, String text, LocalDate sendDateEmail, StatusEmail statusEmail) {
        this.emailId = emailId;
        this.ownrRef = ownrRef;
        this.emailFrom = emailFrom;
        this.emailTo = emailTo;
        this.subject = subject;
        this.text = text;
        this.sendDateEmail = sendDateEmail;
        this.statusEmail = statusEmail;
    }

    public Long getEmailId() {
        return emailId;
    }

    public void setEmailId(Long emailId) {
        this.emailId = emailId;
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

    public LocalDate getSendDateEmail() {
        return sendDateEmail;
    }

    public void setSendDateEmail(LocalDate sendDateEmail) {
        this.sendDateEmail = sendDateEmail;
    }

    public StatusEmail getStatusEmail() {
        return statusEmail;
    }

    public void setStatusEmail(StatusEmail statusEmail) {
        this.statusEmail = statusEmail;
    }
}
