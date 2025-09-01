package com.myProject.kauan_imovel.infrastructure.repository;

import com.myProject.kauan_imovel.domain.venda.VendaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendaRepository extends JpaRepository<VendaEntity, Long> {
}
