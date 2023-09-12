package com.educarparatransformar.web.Service;

import com.educarparatransformar.web.DTO.ComentarioDto;
import com.educarparatransformar.web.Entity.ComentarioEntity;

import java.util.List;

public interface ComentarioService {
    Boolean agregarComentario(ComentarioDto comentarioDto);
    List<ComentarioEntity> obtenerComentarios();
}
