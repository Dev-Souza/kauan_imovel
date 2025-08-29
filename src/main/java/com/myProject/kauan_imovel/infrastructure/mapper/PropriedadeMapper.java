package com.myProject.kauan_imovel.infrastructure.mapper;

import com.myProject.kauan_imovel.application.command.endereco.CadastrarEnderecoCommand;
import com.myProject.kauan_imovel.application.command.propriedade.CadastrarPropriedadeCommand;
import com.myProject.kauan_imovel.domain.endereco.EnderecoEntity;
import com.myProject.kauan_imovel.domain.propriedade.PropriedadeEntity;
import org.mapstruct.*;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface PropriedadeMapper {

    // Cria a Propriedade sem id, sem proprietario e sem endereco
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "proprietario", ignore = true)
    @Mapping(target = "endereco", ignore = true)
    PropriedadeEntity toEntity(CadastrarPropriedadeCommand cmd);

    // Cria Endereco sem id e sem propriedade (serão setados depois)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "propriedade", ignore = true)
    EnderecoEntity toEndereco(CadastrarEnderecoCommand dto);

    /**
     * Conveniência: monta o agregado completo (Propriedade + Endereco)
     * e garante o vínculo bidirecional.
     */
    default PropriedadeEntity toAggregate(CadastrarPropriedadeCommand cmd) {
        PropriedadeEntity prop = toEntity(cmd);
        EnderecoEntity end = toEndereco(cmd.endereco());
        if (end != null) {
            // Usa seu helper para manter ambos os lados consistentes
            prop.definirEndereco(end);
        }
        return prop;
    }

    // Atualização parcial (ignora nulls) da Propriedade
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "proprietario", ignore = true)
    @Mapping(target = "endereco", ignore = true) // endereço atualizado separadamente
    void update(@MappingTarget PropriedadeEntity target, CadastrarPropriedadeCommand src);

    // Atualização parcial do Endereco
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "propriedade", ignore = true)
    void updateEndereco(@MappingTarget EnderecoEntity target, CadastrarEnderecoCommand src);
}

