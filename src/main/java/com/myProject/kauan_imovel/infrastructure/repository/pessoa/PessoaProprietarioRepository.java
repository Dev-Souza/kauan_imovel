package com.myProject.kauan_imovel.infrastructure.repository.pessoa;

import com.myProject.kauan_imovel.domain.pessoa.PessoaProprietarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaProprietarioRepository extends JpaRepository<PessoaProprietarioEntity, Long> {
}
