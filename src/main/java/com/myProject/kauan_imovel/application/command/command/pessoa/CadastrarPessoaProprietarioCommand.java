package com.myProject.kauan_imovel.application.command.command.pessoa;

public record CadastrarPessoaProprietarioCommand(
        String nome,
        String cpf,
        String email,
        String telefone
) {
}
