package com.desktop.DesktopApp.Repository;

import com.desktop.DesktopApp.Entity.EstudianteEntity;
import com.desktop.DesktopApp.Entity.MateriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MateriaRepository extends JpaRepository<MateriaEntity, Long> {
    MateriaEntity findByNombre(String nombre);
}
