package com.educarparatransformar.web.Repository;

import com.educarparatransformar.web.Entity.ComentarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComentarioEntityRepository extends JpaRepository<ComentarioEntity, Long> {
    List<ComentarioEntity> findTop8ByOrderByFechaCreacionDesc();
}