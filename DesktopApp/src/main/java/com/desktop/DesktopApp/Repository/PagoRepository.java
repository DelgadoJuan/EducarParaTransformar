package com.desktop.DesktopApp.Repository;

import com.desktop.DesktopApp.Entity.PagoEntity;
import com.desktop.DesktopApp.Entity.TipoPago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PagoRepository extends JpaRepository<PagoEntity, Long> {
    List<PagoEntity> findByTipoPago(TipoPago tipoPago);
}
