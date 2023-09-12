package com.educarparatransformar.web.Service.Implement;

import com.educarparatransformar.web.Entity.UsuarioEntity;
import com.educarparatransformar.web.Repository.UsuarioRepository;
import com.educarparatransformar.web.Security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsuarioEntity usuarioEntity = usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("No existe un usuario con ese DNI"));
        return new UserPrincipal(usuarioEntity);
        /*List<GrantedAuthority> authorityList = new ArrayList<GrantedAuthority>();
        authorityList.add(new SimpleGrantedAuthority(usuarioEntity.getRol().name()));
        User usuario = new User(username, usuarioEntity.getPassword(), authorityList); */
        /*return User
                .withUsername(username)
                .password(usuarioEntity.getPassword())
                .roles(usuarioEntity.getRol().name())
                .build(); */
    }
}
