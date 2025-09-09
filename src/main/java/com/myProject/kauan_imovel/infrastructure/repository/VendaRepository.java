package com.myProject.kauan_imovel.infrastructure.repository;

import com.myProject.kauan_imovel.domain.venda.VendaEntity;
import com.myProject.kauan_imovel.domain.venda.dto.FaturamentoVendaDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;

public interface VendaRepository extends JpaRepository<VendaEntity, Long> {
    @Query(value = """
            SELECT * FROM venda 
            WHERE EXTRACT(MONTH FROM data_venda) = :mes 
            ORDER BY valor_venda DESC 
            LIMIT 1
            """, nativeQuery = true)
    VendaEntity buscarMaiorVendaDeUmMes(@Param("mes") Integer mes);

    @Query(value = """
            SELECT * FROM venda 
            WHERE EXTRACT(MONTH FROM data_venda) = :mes 
            ORDER BY valor_venda ASC 
            LIMIT 1
            """, nativeQuery = true)
    VendaEntity buscarMenorVendaDeUmMes(@Param("mes") Integer mes);

    @Query(value = "SELECT SUM(valor_venda) FROM venda " +
            "       WHERE EXTRACT(MONTH FROM data_venda) = :mes" +
            "", nativeQuery = true)
    FaturamentoVendaDTO buscarFaturamentoDeUmMes(@Param("mes") Integer mes);

    @Query(value = "SELECT SUM(valor_venda) FROM venda", nativeQuery = true)
    BigDecimal valorDeVendas();


}
