package com.apiMobile.ApiMobileEducarParaTransformar.Repository;

import com.apiMobile.ApiMobileEducarParaTransformar.Entity.HorarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HorarioRepository extends JpaRepository<HorarioEntity, Long> {
}
