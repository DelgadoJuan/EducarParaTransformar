package com.educarparatransformar.web.Converter;

import com.educarparatransformar.web.DTO.UsuarioDto;
import com.educarparatransformar.web.Entity.EstudianteEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UsuarioDtoToEstudianteEntityConverter implements Converter<UsuarioDto, EstudianteEntity> {
    @Override
    public EstudianteEntity convert(UsuarioDto usuarioDto) {
        EstudianteEntity estudiante = new EstudianteEntity();
        estudiante.setUsername(usuarioDto.getUsername());
        estudiante.setEmail(usuarioDto.getEmail());
        estudiante.setPassword(usuarioDto.getPassword());
        estudiante.setNombre(usuarioDto.getNombre());
        estudiante.setFechaNacimiento(usuarioDto.getFechaNacimiento());
        estudiante.setRol(usuarioDto.getRol());
        return estudiante;
    }
}
