package com.myProject.kauan_imovel.utils.mapper;

import com.myProject.kauan_imovel.pessoa.command.command.CadastrarPessoaProprietarioCommand;
import com.myProject.kauan_imovel.pessoa.command.domain.PessoaProprietarioEntity;
import com.myProject.kauan_imovel.pessoa.query.dto.PessoaProprietarioQueryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProprietarioMapper {
    ProprietarioMapper INSTANCE = Mappers.getMapper(ProprietarioMapper.class);

    PessoaProprietarioEntity toEntity(CadastrarPessoaProprietarioCommand command);
    List<PessoaProprietarioEntity> toEntities(List<CadastrarPessoaProprietarioCommand> commands);

    PessoaProprietarioQueryDTO toDTO(PessoaProprietarioEntity entity);
    List<PessoaProprietarioQueryDTO> toDTOs(List<PessoaProprietarioEntity> entities);
}
