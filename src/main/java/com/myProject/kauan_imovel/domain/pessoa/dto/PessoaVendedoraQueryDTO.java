package com.myProject.kauan_imovel.domain.pessoa.dto;

import java.time.LocalDate;

public record PessoaVendedoraQueryDTO(
        Long id,
        String nome,
        String cpf,
        String email,
        String telefone,
        String creci,
        LocalDate dataContratacao
) {
}
