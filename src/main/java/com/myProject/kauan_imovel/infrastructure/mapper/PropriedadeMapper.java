package com.myProject.kauan_imovel.infrastructure.mapper;

import com.myProject.kauan_imovel.application.command.endereco.CadastrarEnderecoCommand;
import com.myProject.kauan_imovel.application.command.propriedade.CadastrarPropriedadeCommand;
import com.myProject.kauan_imovel.domain.endereco.EnderecoEntity;
import com.myProject.kauan_imovel.domain.propriedade.PropriedadeEntity;
import com.myProject.kauan_imovel.domain.propriedade.dto.PropriedadeQueryDTO;
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
    @Mapping(target = "vendas", ignore = true)
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
    @Mapping(target = "vendas", ignore = true)
    void update(@MappingTarget PropriedadeEntity target, CadastrarPropriedadeCommand src);

    // Atualização parcial do Endereco
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "propriedade", ignore = true)
    void updateEndereco(@MappingTarget EnderecoEntity target, CadastrarEnderecoCommand src);


    // Copia todos os campos do command para a entidade existente (menos id, proprietário e endereço)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "proprietario", ignore = true) // setamos no handler
    @Mapping(target = "endereco", ignore = true)     // setamos/tratamos no handler
    @Mapping(target = "vendas", ignore = true)
    void copy(@MappingTarget PropriedadeEntity target, CadastrarPropriedadeCommand src);

    // PUT/UPDATE: copia campos do endereço
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "propriedade", ignore = true) // back-reference: setamos no handler
    void copyEndereco(@MappingTarget EnderecoEntity target, CadastrarEnderecoCommand src);

     default PropriedadeQueryDTO toDTO(PropriedadeEntity propriedadeEntity) {
        return new PropriedadeQueryDTO(
                propriedadeEntity.getId(),
                propriedadeEntity.getTitulo(),
                propriedadeEntity.getTipoPropriedade(),
                propriedadeEntity.getAreaPropriedade(),
                propriedadeEntity.getNumeroQuartos(),
                propriedadeEntity.getNumeroBanheiros(),
                propriedadeEntity.getPrecoPropriedade(),
                propriedadeEntity.isDisponivel(),
                propriedadeEntity.getProprietario().getId(),
                propriedadeEntity.getEndereco().getId()
        );
    }
}

