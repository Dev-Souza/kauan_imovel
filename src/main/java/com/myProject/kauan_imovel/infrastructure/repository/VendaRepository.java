package com.myProject.kauan_imovel.infrastructure.repository;

import com.myProject.kauan_imovel.domain.venda.VendaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface VendaRepository extends JpaRepository<VendaEntity, Long> {
    @Query(value = """
            SELECT * FROM venda 
            WHERE EXTRACT(MONTH FROM data_venda) = :mes 
            ORDER BY valor_venda DESC 
            LIMIT 1
            """, nativeQuery = true)
    VendaEntity buscarMaiorVendaDeUmMes(@Param("mes") Integer mes);
}
