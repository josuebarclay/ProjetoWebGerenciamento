package com.autocom.helpdesk.model;

import com.autocom.helpdesk.enums.Perfil;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class ClienteUserDetailsImpl implements UserDetails {

    private Cliente cliente;

    public ClienteUserDetailsImpl(Cliente cliente){
        this.cliente = cliente;
    }

    public String getNome(){ return cliente.getNome();}

    public Integer getId(){ return cliente.getId();}

    public String displayImage(){
        return cliente.getImagem();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Perfil perfil = cliente.getPerfil();
        if(perfil == Perfil.ADMIN){
            perfil = Perfil.ADMIN;
        }else {
            perfil = Perfil.CLIENTE;
        }
        return AuthorityUtils.createAuthorityList(perfil.toString());
    }

    @Override
    public String getPassword() {
        return cliente.getSenha();
    }

    @Override
    public String getUsername() {
        return cliente.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
