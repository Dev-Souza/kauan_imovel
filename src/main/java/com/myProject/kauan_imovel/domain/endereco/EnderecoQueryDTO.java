package com.myProject.kauan_imovel.domain.endereco;

public record EnderecoQueryDTO(
        Long id,
        String cep,
        String logradouro,
        String localidade,
        String uf,
        String bairro
) {
}
