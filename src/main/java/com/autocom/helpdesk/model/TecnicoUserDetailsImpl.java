package com.autocom.helpdesk.model;

import com.autocom.helpdesk.enums.Perfil;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class TecnicoUserDetailsImpl implements UserDetails {

    private Tecnico tecnico;

    public TecnicoUserDetailsImpl(Tecnico tecnico){
        this.tecnico = tecnico;
    }

    public String getNome(){ return tecnico.getNome();}

    public Integer getId(){ return tecnico.getId();}

    public String displayImage(){
        return tecnico.getImagem();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Perfil perfil = tecnico.getPerfil();
        if(perfil == Perfil.ADMIN){
            perfil = Perfil.ADMIN;
        }else {
            perfil = Perfil.TECNICO;
        }
        return AuthorityUtils.createAuthorityList(perfil.toString());
    }

    @Override
    public String getPassword() {
        return tecnico.getSenha();
    }

    @Override
    public String getUsername() {
        return tecnico.getEmail();
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
