package com.myProject.kauan_imovel.domain.propriedade.dto;

import com.myProject.kauan_imovel.domain.propriedade.TipoPropriedadeEnum;

import java.math.BigDecimal;

public record PropriedadeQueryDTO(
        Long id,
        String titulo,
        TipoPropriedadeEnum tipoPropriedade,
        double areaPropriedade,
        Integer numeroQuartos,
        Integer numeroBanheiros,
        BigDecimal precoPropriedade,
        boolean disponivel,
        Long proprietario,
        Long endereco
) {
}
