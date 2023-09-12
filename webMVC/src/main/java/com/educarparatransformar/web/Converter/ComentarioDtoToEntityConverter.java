package com.educarparatransformar.web.Converter;

import com.educarparatransformar.web.DTO.ComentarioDto;
import com.educarparatransformar.web.Entity.ComentarioEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ComentarioDtoToEntityConverter implements Converter<ComentarioDto, ComentarioEntity> {

    @Override
    public ComentarioEntity convert(ComentarioDto comentarioDto) {
        ComentarioEntity comentario = new ComentarioEntity();
        comentario.setNombre(comentarioDto.getNombre());
        comentario.setDescripcion(comentarioDto.getDescripcion());
        return comentario;
    }
}
