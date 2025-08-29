package com.myProject.kauan_imovel.application.command.endereco;

public record CadastrarEnderecoCommand(
        String cep,
        String logradouro,
        String localidade,
        String uf,
        String bairro
) {
}
