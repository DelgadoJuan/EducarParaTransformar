package com.educarparatransformar.web.Repository;

import com.educarparatransformar.web.Entity.MateriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MateriaRepository extends JpaRepository<MateriaEntity, Long> {
    MateriaEntity findByNombre(String nombre);
}
