package com.desktop.DesktopApp.Repository;

import com.desktop.DesktopApp.Entity.EstudianteEntity;
import com.desktop.DesktopApp.Entity.MateriaEntity;
import com.desktop.DesktopApp.Entity.ProfesorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfesorRepository extends JpaRepository<ProfesorEntity, Long> {
    //List<MateriaEntity> findAllMaterias(ProfesorEntity profesor);
    ProfesorEntity findByUsername(String dni);
}
