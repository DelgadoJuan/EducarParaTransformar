package com.educarparatransformar.web.Converter;

import com.educarparatransformar.web.DTO.UsuarioDto;
import com.educarparatransformar.web.Entity.UsuarioEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UsuarioDtoToEntityConverter implements Converter<UsuarioDto, UsuarioEntity> {
    @Override
    public UsuarioEntity convert(UsuarioDto usuarioDto) {
        UsuarioEntity usuario = new UsuarioEntity();
        usuario.setUsername(usuarioDto.getUsername());
        usuario.setEmail(usuarioDto.getEmail());
        usuario.setPassword(usuarioDto.getPassword());
        usuario.setNombre(usuarioDto.getNombre());
        usuario.setFechaNacimiento(usuarioDto.getFechaNacimiento());
        usuario.setRol(usuarioDto.getRol());
        return usuario;
    }
}
