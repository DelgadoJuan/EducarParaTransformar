package com.educarparatransformar.web.Service.Implement;

import com.educarparatransformar.web.DTO.UsuarioDto;
import com.educarparatransformar.web.Entity.UsuarioEntity;
import com.educarparatransformar.web.Repository.UsuarioRepository;
import com.educarparatransformar.web.Security.UserPrincipal;
import com.educarparatransformar.web.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    Converter<UsuarioDto, UsuarioEntity> UsuarioDtoToEntityConverter;

    @Override
    public Boolean agregar(UsuarioDto usuarioDto) {
        usuarioDto.setPassword(passwordEncoder.encode(usuarioDto.getPassword()));
        usuarioRepository.save(UsuarioDtoToEntityConverter.convert(usuarioDto));
        return true;
    }

    @Override
    public Boolean editarUsuario(UsuarioDto usuarioDto, String username) {
        UsuarioEntity usuarioEntity = usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("No existe un usuario con ese DNI"));
        usuarioEntity.setNombre(usuarioDto.getNombre());
        usuarioEntity.setPassword(passwordEncoder.encode(usuarioDto.getPassword()));
        usuarioRepository.save(usuarioEntity);
        return true;
    }

    @Override
    public Boolean eliminarUsuario(String username) {
        usuarioRepository.deleteByUsername(username);
        return true;
    }

    /*@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsuarioEntity usuarioEntity = usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("No existe un usuario con ese DNI"));
        //return new UserPrincipal(usuarioEntity);
        /*List<GrantedAuthority> authorityList = new ArrayList<GrantedAuthority>();
        authorityList.add(new SimpleGrantedAuthority(usuarioEntity.getRol().name()));
        User usuario = new User(username, usuarioEntity.getPassword(), authorityList);
        return User
                .withUsername(username)
                .password(usuarioEntity.getPassword())
                .roles(usuarioEntity.getRol().name())
                .build();
    }*/

}