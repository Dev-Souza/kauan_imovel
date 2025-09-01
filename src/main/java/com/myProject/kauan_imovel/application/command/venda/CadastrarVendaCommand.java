package com.myProject.kauan_imovel.application.command.venda;

import com.myProject.kauan_imovel.domain.venda.FormaPagamentoEnum;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public record CadastrarVendaCommand(
        LocalDate dataVenda,
        BigDecimal valorVenda,
        FormaPagamentoEnum formaPagamento,
        List<Long> propriedades,
        Long vendedorId,
        Long compradorId,
        Long proprietarioId
) {
}