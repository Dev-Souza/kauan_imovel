package com.myProject.kauan_imovel.domain.pessoa.dto;

import com.myProject.kauan_imovel.domain.venda.dto.VendaDTO;

import java.math.BigDecimal;
import java.util.List;

public record PessoaCompradoraQueryDTO(
        Long id,
        String nome,
        String cpf,
        String email,
        String telefone,
        BigDecimal faixaPrecoDesejada,
        Boolean possuiFinanciamentoAprovado,
        String instituicaoFinanceira,
        List<VendaDTO> compras
) {
}
