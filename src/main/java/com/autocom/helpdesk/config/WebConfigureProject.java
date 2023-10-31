package com.autocom.helpdesk.config;

import com.autocom.helpdesk.service.ClienteUserDetailsService;
import com.autocom.helpdesk.service.TecnicoUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
@EnableWebSecurity
public class WebConfigureProject extends WebSecurityConfigurerAdapter {

    @Autowired
    private TecnicoUserDetailsService tecnicoUserDetailsService;

    @Autowired
    private ClienteUserDetailsService clienteUserDetailsService;

    //recuruso que vai permitir e bloquear na aplicação
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/sucesso/sucessoEmail").permitAll()
                .antMatchers("/sucessoEmail").permitAll()
                .antMatchers("/assets-autocom/**").permitAll()
                .antMatchers("/img-autocom/**").permitAll()
                .antMatchers("/js-autocom/**").permitAll()
                .antMatchers("/scss-autocom/**").permitAll()
                .antMatchers("/vendor-autocom/**").permitAll()
                .antMatchers("/css-autocom/**").permitAll()
                .antMatchers("/css/**").permitAll()
                .antMatchers("/js/**").permitAll()
                .antMatchers("/images/**").permitAll()
                .antMatchers("/vendors/**").permitAll()
                .antMatchers("/fonts/**").permitAll()
                .anyRequest().authenticated();

        http.formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/autocom/autocom") // Redirecionar para a página inicial do técnico
                .permitAll();

        http.rememberMe()
                .key("keyRemeber");

        http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(clienteUserDetailsService)
                .passwordEncoder(new BCryptPasswordEncoder());
        auth.userDetailsService(tecnicoUserDetailsService)
                .passwordEncoder(new BCryptPasswordEncoder());
    }
}
