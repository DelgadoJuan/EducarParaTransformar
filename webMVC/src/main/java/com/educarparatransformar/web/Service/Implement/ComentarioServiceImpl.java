package com.educarparatransformar.web.Service.Implement;

import com.educarparatransformar.web.Converter.ComentarioDtoToEntityConverter;
import com.educarparatransformar.web.DTO.ComentarioDto;
import com.educarparatransformar.web.Entity.ComentarioEntity;
import com.educarparatransformar.web.Repository.ComentarioEntityRepository;
import com.educarparatransformar.web.Service.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComentarioServiceImpl implements ComentarioService {

    private ComentarioEntityRepository comentarioEntityRepository;
    private ComentarioDtoToEntityConverter comentarioDtoToEntityConverter;

    @Autowired
    public ComentarioServiceImpl(ComentarioEntityRepository comentarioEntityRepository, ComentarioDtoToEntityConverter comentarioDtoToEntityConverter) {
        this.comentarioEntityRepository = comentarioEntityRepository;
        this.comentarioDtoToEntityConverter = comentarioDtoToEntityConverter;
    }

    @Override
    public Boolean agregarComentario(ComentarioDto comentarioDto) {
        comentarioEntityRepository.save(comentarioDtoToEntityConverter.convert(comentarioDto));
        return true;
    }

    @Override
    public List<ComentarioEntity> obtenerComentarios() {
        return comentarioEntityRepository.findTop8ByOrderByFechaCreacionDesc();
}
}
