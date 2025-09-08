package com.myProject.kauan_imovel.infrastructure.repository;

import com.myProject.kauan_imovel.domain.pessoa.PessoaVendedoraEntity;
import com.myProject.kauan_imovel.domain.venda.VendaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface PessoaVendedoraRepository extends JpaRepository<PessoaVendedoraEntity,Long> {
    @Query(value = """
    SELECT p.*
    FROM pessoa_vendedora p
    JOIN venda v ON p.id = v.vendedor_id
    WHERE v.data_venda BETWEEN :dataInicial AND :dataFinal
    GROUP BY p.id, p.cpf, p.creci, p.data_contratacao, p.email, p.nome, p.telefone
    ORDER BY SUM(v.valor_venda) DESC
    LIMIT 1
""", nativeQuery = true)
    PessoaVendedoraEntity vendedorQueMaisVendeu(@Param("dataInicial") LocalDate dataInicial, @Param("dataFinal") LocalDate dataFinal);
}
