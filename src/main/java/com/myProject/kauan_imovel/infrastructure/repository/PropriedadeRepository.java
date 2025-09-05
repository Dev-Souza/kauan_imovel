package com.myProject.kauan_imovel.infrastructure.repository;

import com.myProject.kauan_imovel.domain.propriedade.PropriedadeEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PropriedadeRepository extends JpaRepository<PropriedadeEntity, Long> {
    @Modifying
    @Transactional
    @Query("UPDATE PropriedadeEntity p SET p.disponivel = false WHERE p.id = :idImovel")
    void alterarDiponibilidadeDoImovel(@Param("idImovel") Long idImovel);

    @Query("SELECT p FROM PropriedadeEntity p WHERE p.disponivel = true")
    List<PropriedadeEntity> findAllDisponivelQuery();

    @Query("SELECT p FROM PropriedadeEntity p WHERE p.precoPropriedade = (SELECT MAX(p2.precoPropriedade) FROM PropriedadeEntity p2)")
    PropriedadeEntity findPropriedadeComMaiorPreco();
}
