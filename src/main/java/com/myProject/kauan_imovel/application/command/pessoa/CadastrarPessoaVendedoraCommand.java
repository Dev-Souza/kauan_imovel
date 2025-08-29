package com.myProject.kauan_imovel.application.command.pessoa;

import java.time.LocalDate;

public record CadastrarPessoaVendedoraCommand(
        String nome,
        String cpf,
        String email,
        String telefone,
        String creci,
        LocalDate dataContratacao
) {
}
