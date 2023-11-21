package com.apiMobile.ApiMobileEducarParaTransformar.Repository;

import com.apiMobile.ApiMobileEducarParaTransformar.Entity.AulaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AulaRepository extends JpaRepository<AulaEntity, Long> {
}
