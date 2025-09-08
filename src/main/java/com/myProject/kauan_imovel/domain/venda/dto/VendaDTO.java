package com.myProject.kauan_imovel.domain.venda.dto;

import com.myProject.kauan_imovel.domain.venda.FormaPagamentoEnum;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public record VendaDTO(
        Long id,
        LocalDate dataVenda,
        BigDecimal valorVenda,
        FormaPagamentoEnum formaPagamento,
        List<Long> propriedades,
        Long vendedorId,
        Long proprietarioId
) {
}
