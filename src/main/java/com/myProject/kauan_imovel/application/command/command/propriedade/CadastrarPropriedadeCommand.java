package com.myProject.kauan_imovel.application.command.command.propriedade;

import com.myProject.kauan_imovel.domain.propriedade.TipoPropriedadeEnum;

import java.math.BigDecimal;

public record CadastrarPropriedadeCommand(
    String titulo,
    TipoPropriedadeEnum tipoPropriedade,
    double areaPropriedade,
    Integer numeroQuartos,
    Integer numeroBanheiros,
    BigDecimal precoPropriedade,
    boolean disponivel
) {
}
