package com.myProject.kauan_imovel.infrastructure.repository;

import com.myProject.kauan_imovel.domain.propriedade.PropriedadeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropriedadeRepository extends JpaRepository<PropriedadeEntity, Long> {
}
