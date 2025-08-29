package com.myProject.kauan_imovel.infrastructure.repository;

import com.myProject.kauan_imovel.domain.endereco.EnderecoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<EnderecoEntity, Long> {
}
