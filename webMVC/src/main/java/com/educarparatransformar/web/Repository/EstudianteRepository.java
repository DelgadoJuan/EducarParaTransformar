package com.educarparatransformar.web.Repository;

import com.educarparatransformar.web.Entity.CursoEntity;
import com.educarparatransformar.web.Entity.EstudianteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstudianteRepository extends JpaRepository<EstudianteEntity, Long> {
    List<EstudianteEntity> findByCurso(CursoEntity curso);
    EstudianteEntity findByUsername(String dni);
}
