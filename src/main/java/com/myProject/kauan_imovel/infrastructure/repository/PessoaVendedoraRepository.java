package com.myProject.kauan_imovel.infrastructure.repository;

import com.myProject.kauan_imovel.domain.pessoa.PessoaVendedoraEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaVendedoraRepository extends JpaRepository<PessoaVendedoraEntity,Long> {
}
