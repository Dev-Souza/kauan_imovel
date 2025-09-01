package com.myProject.kauan_imovel.application.command.pessoa;

import java.math.BigDecimal;

public record CadastrarPessoaCompradoraCommand(
        String nome,
        String cpf,
        String email,
        String telefone,
        BigDecimal faixaPrecoDesejada,
        boolean possuiFinanciamentoAprovado,
        String instituicaoFinanceira
) {
}
