package com.educarparatransformar.web.Converter;

import com.educarparatransformar.web.DTO.UsuarioDto;
import com.educarparatransformar.web.Entity.EstudianteEntity;
import com.educarparatransformar.web.Entity.ProfesorEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UsuarioDtoToProfesorEntityConverter implements Converter<UsuarioDto, ProfesorEntity> {
    @Override
    public ProfesorEntity convert(UsuarioDto usuarioDto) {
        ProfesorEntity profesor = new ProfesorEntity();
        profesor.setUsername(usuarioDto.getUsername());
        profesor.setEmail(usuarioDto.getEmail());
        profesor.setPassword(usuarioDto.getPassword());
        profesor.setNombre(usuarioDto.getNombre());
        profesor.setFechaNacimiento(usuarioDto.getFechaNacimiento());
        profesor.setRol(usuarioDto.getRol());
        return profesor;
    }
}
