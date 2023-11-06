package com.educarparatransformar.web.Converter;

import com.educarparatransformar.web.DTO.UsuarioDto;
import com.educarparatransformar.web.Entity.TitularEntity;
import org.springframework.stereotype.Component;
import org.springframework.core.convert.converter.Converter;

@Component
public class UsuarioDtoToTitularEntityConverter implements Converter<UsuarioDto, TitularEntity>{
    @Override
    public TitularEntity convert(UsuarioDto usuarioDto) {
        TitularEntity titular = new TitularEntity();
        titular.setUsername(usuarioDto.getUsername());
        titular.setEmail(usuarioDto.getEmail());
        titular.setPassword(usuarioDto.getPassword());
        titular.setNombre(usuarioDto.getNombre());
        titular.setFechaNacimiento(usuarioDto.getFechaNacimiento());
        titular.setRol(usuarioDto.getRol());
        return titular;
    }
}
