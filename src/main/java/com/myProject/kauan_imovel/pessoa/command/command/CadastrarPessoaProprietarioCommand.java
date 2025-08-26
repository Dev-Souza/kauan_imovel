package com.myProject.kauan_imovel.pessoa.command.command;

public record CadastrarPessoaProprietarioCommand(
        String nome,
        String cpf,
        String email,
        String telefone
) {
}
