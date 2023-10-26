package com.autocom.helpdesk.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtil {

    public static String encoder(String senha ){
        BCryptPasswordEncoder encoderSErnha = new BCryptPasswordEncoder();
        return encoderSErnha.encode(senha);
    }

    // comparar as senhas
    public static boolean matchersPassword(String senhaRequest, String senhahashBD){
        BCryptPasswordEncoder encoderSenha = new BCryptPasswordEncoder();
        return encoderSenha.matches(senhaRequest, senhahashBD);
    }
}
