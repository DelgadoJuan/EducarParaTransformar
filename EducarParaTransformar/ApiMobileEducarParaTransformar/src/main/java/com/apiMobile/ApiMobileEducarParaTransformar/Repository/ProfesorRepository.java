package com.apiMobile.ApiMobileEducarParaTransformar.Repository;

import com.apiMobile.ApiMobileEducarParaTransformar.Entity.ProfesorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfesorRepository extends JpaRepository<ProfesorEntity, Long> {
    //List<MateriaEntity> findAllMaterias(ProfesorEntity profesor);
    ProfesorEntity findByUsername(String dni);
}
