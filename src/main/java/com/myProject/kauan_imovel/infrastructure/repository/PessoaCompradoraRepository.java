package com.myProject.kauan_imovel.infrastructure.repository;

import com.myProject.kauan_imovel.domain.pessoa.PessoaCompradoraEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaCompradoraRepository extends JpaRepository<PessoaCompradoraEntity, Long> {
}
