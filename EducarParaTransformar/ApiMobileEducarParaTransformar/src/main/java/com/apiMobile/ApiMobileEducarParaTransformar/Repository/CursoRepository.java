package com.apiMobile.ApiMobileEducarParaTransformar.Repository;

import com.apiMobile.ApiMobileEducarParaTransformar.Entity.CursoEntity;
import com.apiMobile.ApiMobileEducarParaTransformar.Entity.EstudianteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CursoRepository extends JpaRepository<CursoEntity, Long> {
    List<EstudianteEntity> findByAlumnosInscriptosNombre(CursoEntity nombreCurso);
    CursoEntity findByAño(String año);
}
