package com.myProject.kauan_imovel.infrastructure.mapper;

import com.myProject.kauan_imovel.application.command.command.pessoa.CadastrarPessoaVendedoraCommand;
import com.myProject.kauan_imovel.domain.pessoa.PessoaVendedoraEntity;
import com.myProject.kauan_imovel.domain.pessoa.dto.PessoaVendedoraQueryDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class VendedorMapper {
    public PessoaVendedoraEntity toEntity(CadastrarPessoaVendedoraCommand cmd) {
        if ( cmd == null ) {
            return null;
        }
        PessoaVendedoraEntity entity = new PessoaVendedoraEntity();
        entity.setNome(cmd.nome());
        entity.setCpf(cmd.cpf());
        entity.setEmail(cmd.email());
        entity.setTelefone(cmd.telefone());
        entity.setCreci(cmd.creci());
        entity.setDataContratacao(LocalDate.now());
        return entity;
    }

    public static PessoaVendedoraQueryDTO toQueryDTO(PessoaVendedoraEntity entity) {
        if ( entity == null ) {
            return null;
        }

        return new PessoaVendedoraQueryDTO(
                entity.getId(),
                entity.getNome(),
                entity.getCpf(),
                entity.getEmail(),
                entity.getTelefone(),
                entity.getCreci(),
                entity.getDataContratacao()
        );
    }
}