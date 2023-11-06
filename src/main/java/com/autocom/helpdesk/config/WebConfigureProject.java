package com.autocom.helpdesk.config;

import com.autocom.helpdesk.enums.Perfil;
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

import static org.hibernate.criterion.Restrictions.and;

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
                .antMatchers("/tecnico/**","/cliente/**","/bairro/**","/visita/**","/ticket/**","/list-filtro/**").hasAnyAuthority(String.valueOf(Perfil.TECNICO.name()), Perfil.ADMIN.name())
                .anyRequest().authenticated();

        http.formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/autocom/autocom") // Redirecionar para a página inicial do técnico por padrão
                .successHandler((request, response, authentication) -> {
                    // Redirecionar para /boletos se o usuário tiver a função "CLIENTE"
                    if (authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("CLIENTE"))) {
                        response.sendRedirect("/boletos/list-boletos");
                    } else {
                        response.sendRedirect("/autocom/autocom"); // Redirecionar para a página do técnico se não for cliente
                    }
                })
                .permitAll();

        http.rememberMe()
                .key("keyRemeber");
        http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(clienteUserDetailsService)
                .passwordEncoder(new BCryptPasswordEncoder())
                .and()
                .userDetailsService(tecnicoUserDetailsService)
                .passwordEncoder(new BCryptPasswordEncoder());
    }

}
