package com.myProject.kauan_imovel.infrastructure.mapper;

import com.myProject.kauan_imovel.application.command.pessoa.CadastrarPessoaProprietarioCommand;
import com.myProject.kauan_imovel.domain.pessoa.PessoaProprietarioEntity;
import com.myProject.kauan_imovel.domain.pessoa.dto.PessoaProprietarioQueryDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ProprietarioMapper{

    public PessoaProprietarioEntity toEntity(CadastrarPessoaProprietarioCommand cmd) {
        if ( cmd == null ) {
            return null;
        }
        PessoaProprietarioEntity entity = new PessoaProprietarioEntity();
        entity.setNome(cmd.nome());
        entity.setCpf(cmd.cpf());
        entity.setEmail(cmd.email());
        entity.setTelefone(cmd.telefone());
        entity.setDataCadastro(LocalDate.now());
        entity.setObservacoes(cmd.observacoes());
        return entity;
    }

    public static PessoaProprietarioQueryDTO toQueryDTO(PessoaProprietarioEntity entity) {
        if ( entity == null ) {
            return null;
        }

        return new PessoaProprietarioQueryDTO(
                entity.getId(),
                entity.getNome(),
                entity.getCpf(),
                entity.getEmail(),
                entity.getTelefone(),
                entity.getDataCadastro(),
                entity.getObservacoes()
        );
    }
}
