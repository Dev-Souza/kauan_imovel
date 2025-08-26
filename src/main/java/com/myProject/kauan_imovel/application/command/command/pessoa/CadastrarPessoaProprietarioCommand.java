package com.myProject.kauan_imovel.application.command.command.pessoa;

import java.time.LocalDate;

public record CadastrarPessoaProprietarioCommand(
        String nome,
        String cpf,
        String email,
        String telefone,
        LocalDate dataCadastro,
        String observacoes
) {
    public static CadastrarPessoaProprietarioCommand comDataAtual(
            String nome, String cpf, String email, String telefone, String observacoes
    ) {
        return new CadastrarPessoaProprietarioCommand(nome, cpf, email, telefone, LocalDate.now(), observacoes);
    }
}

