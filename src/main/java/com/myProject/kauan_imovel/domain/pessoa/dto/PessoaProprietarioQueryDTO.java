package com.myProject.kauan_imovel.domain.pessoa.dto;

import java.time.LocalDate;

public record PessoaProprietarioQueryDTO(
        Long id,
        String nome,
        String cpf,
        String email,
        String telefone,
        LocalDate dataCadastro,
        String observacoes
) {
}
