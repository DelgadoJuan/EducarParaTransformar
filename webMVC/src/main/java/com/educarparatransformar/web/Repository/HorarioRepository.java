package com.educarparatransformar.web.Repository;

import com.educarparatransformar.web.Entity.HorarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HorarioRepository extends JpaRepository<HorarioEntity, Long> {
}
