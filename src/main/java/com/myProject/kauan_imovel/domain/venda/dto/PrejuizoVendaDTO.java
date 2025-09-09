package com.myProject.kauan_imovel.domain.venda.dto;

import java.math.BigDecimal;
import java.util.List;

public record PrejuizoVendaDTO(
        List<BigDecimal> valoresPropriedades,
        BigDecimal valorVenda,
        BigDecimal valorPrejuizo
) {
}
