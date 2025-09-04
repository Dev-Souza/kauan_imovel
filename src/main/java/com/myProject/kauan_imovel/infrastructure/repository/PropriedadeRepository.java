package com.myProject.kauan_imovel.infrastructure.repository;

import com.myProject.kauan_imovel.domain.propriedade.PropriedadeEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PropriedadeRepository extends JpaRepository<PropriedadeEntity, Long> {
    @Modifying
    @Transactional
    @Query("UPDATE PropriedadeEntity p SET p.disponivel = false WHERE p.id = :idImovel")
    void alterarDiponibilidadeDoImovel(@Param("idImovel") Long idImovel);
}
