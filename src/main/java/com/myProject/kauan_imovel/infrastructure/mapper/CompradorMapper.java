package com.myProject.kauan_imovel.infrastructure.mapper;

import com.myProject.kauan_imovel.application.command.pessoa.CadastrarPessoaCompradoraCommand;
import com.myProject.kauan_imovel.domain.pessoa.PessoaCompradoraEntity;
import com.myProject.kauan_imovel.domain.pessoa.dto.PessoaCompradoraQueryDTO;
import org.springframework.stereotype.Component;

@Component
public class CompradorMapper {

    public PessoaCompradoraEntity toEntity(CadastrarPessoaCompradoraCommand cmd){
        if ( cmd == null ) {
            return null;
        }
        PessoaCompradoraEntity entity = new PessoaCompradoraEntity();
        entity.setNome(cmd.nome());
        entity.setCpf(cmd.cpf());
        entity.setEmail(cmd.email());
        entity.setTelefone(cmd.telefone());
        entity.setFaixaPrecoDesejada(cmd.faixaPrecoDesejada());
        entity.setPossuiFinanciamentoAprovado(cmd.possuiFinanciamentoAprovado());
        entity.setInstituicaoFinanceira(cmd.instituicaoFinanceira());
        return entity;
    }

    public static PessoaCompradoraQueryDTO toDTO(PessoaCompradoraEntity entity){
        if ( entity == null ) {
            return null;
        }

        return new PessoaCompradoraQueryDTO(
                entity.getId(),
                entity.getNome(),
                entity.getCpf(),
                entity.getEmail(),
                entity.getTelefone(),
                entity.getFaixaPrecoDesejada(),
                entity.getPossuiFinanciamentoAprovado(),
                entity.getInstituicaoFinanceira(),
                entity.getCompras()
        );
    }
}
