package com.apiMobile.ApiMobileEducarParaTransformar.Repository;

import com.apiMobile.ApiMobileEducarParaTransformar.Entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
    Optional<UsuarioEntity> findByUsername(String username);

    void deleteByUsername(String username);
}
