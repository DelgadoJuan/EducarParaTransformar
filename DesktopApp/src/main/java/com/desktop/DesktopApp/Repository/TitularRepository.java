package com.desktop.DesktopApp.Repository;

import com.desktop.DesktopApp.Entity.TitularEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TitularRepository extends JpaRepository<TitularEntity, Long> {
    TitularEntity findByUsername(String dni);
}
