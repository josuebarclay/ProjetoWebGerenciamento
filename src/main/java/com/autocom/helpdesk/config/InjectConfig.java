package com.autocom.helpdesk.config;

import com.autocom.helpdesk.service.InjectDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("prod")
public class InjectConfig {

    @Autowired
    private InjectDB injectDB;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String value;

    @Bean
    public boolean injectDbInfos() {
        if (value.equals("create")) {
            this.injectDB.injectDB();
            return true;
        }
        return false;
    }
}