package com.autocom.helpdesk.service;

import com.autocom.helpdesk.enums.StatusEmail;
import com.autocom.helpdesk.model.EmailModel;
import com.autocom.helpdesk.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    EmailRepository emailRepository;


    public EmailModel sendEmail(EmailModel emailModel) {
        emailModel.setSendDateEmail(LocalDate.now());
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(emailModel.getEmailFrom());
            message.setTo("suporte3@autocominformatica.com");
            message.setSubject(emailModel.getSubject());
            message.setText(emailModel.getText());
            javaMailSender.send(message);

            emailModel.setStatusEmail(StatusEmail.SENT);
        } catch (MailException e) {
            emailModel.setStatusEmail(StatusEmail.ERROR);
            // Registre os detalhes do erro (você pode escolher como deseja registrar, por exemplo, usando um logger)
            // Aqui, estamos apenas imprimindo os detalhes do erro no console
            e.printStackTrace();
        } finally {
            // Salva o modelo de e-mail no repositório
            return emailRepository.save(emailModel);
        }
    }

}
