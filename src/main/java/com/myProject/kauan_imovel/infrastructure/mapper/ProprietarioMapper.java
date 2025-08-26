package com.myProject.kauan_imovel.infrastructure.mapper;

import com.myProject.kauan_imovel.application.command.command.pessoa.CadastrarPessoaProprietarioCommand;
import com.myProject.kauan_imovel.domain.pessoa.PessoaProprietarioEntity;
import com.myProject.kauan_imovel.domain.pessoa.dto.PessoaProprietarioQueryDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProprietarioMapper {
    PessoaProprietarioEntity toEntity(CadastrarPessoaProprietarioCommand command);
    List<PessoaProprietarioEntity> toEntities(List<CadastrarPessoaProprietarioCommand> commands);

    PessoaProprietarioQueryDTO toDTO(PessoaProprietarioEntity entity);
    List<PessoaProprietarioQueryDTO> toDTOs(List<PessoaProprietarioEntity> entities);
}
