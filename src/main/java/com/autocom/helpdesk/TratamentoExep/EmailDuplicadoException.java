package com.autocom.helpdesk.TratamentoExep;

public class EmailDuplicadoException extends RuntimeException {
    public EmailDuplicadoException(String message) {
        super(message);
    }

    private static final long SerialVersionUID = 1L;
}