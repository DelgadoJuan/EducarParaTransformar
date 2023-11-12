package com.educarparatransformar.web.Security;

import com.educarparatransformar.web.Entity.UsuarioEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

import java.util.*;


public class UserPrincipal implements UserDetails {

    private UsuarioEntity usuarioEntity;

    public UserPrincipal(UsuarioEntity usuarioEntity) {
        super();
        this.usuarioEntity = usuarioEntity;
    }

    public UsuarioEntity getUsuarioEntity() {
        return usuarioEntity;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //return Arrays.stream(StringUtils.tokenizeToStringArray(this.usuarioEntity.getRol().name(), " "))
         //       .map(rol -> new SimpleGrantedAuthority("ROLE_" + rol))
          //      .toList();

        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(usuarioEntity.getRol().name());
        return List.of(authority);

    }

    @Override
    public String getPassword() {
        return this.usuarioEntity.getPassword();
    }

    @Override
    public String getUsername() {
        return this.usuarioEntity.getUsername();
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
