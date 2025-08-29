package com.myProject.kauan_imovel.infrastructure.repository;

import com.myProject.kauan_imovel.domain.pessoa.PessoaProprietarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaProprietarioRepository extends JpaRepository<PessoaProprietarioEntity, Long> {
}
