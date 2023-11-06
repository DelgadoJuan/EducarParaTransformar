package com.educarparatransformar.web.Repository;

import com.educarparatransformar.web.Entity.PagoEntity;
import com.educarparatransformar.web.DTO.TipoPago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PagoRepository extends JpaRepository<PagoEntity, Long> {
    List<PagoEntity> findByTipoPago(TipoPago tipoPago);
}
