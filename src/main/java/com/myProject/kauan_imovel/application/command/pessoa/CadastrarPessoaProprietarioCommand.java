package com.myProject.kauan_imovel.application.command.pessoa;

import java.time.LocalDate;

public record CadastrarPessoaProprietarioCommand(
        String nome,
        String cpf,
        String email,
        String telefone,
        LocalDate dataCadastro,
        String observacoes
) {}

