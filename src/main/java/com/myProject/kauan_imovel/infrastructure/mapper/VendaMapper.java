package com.myProject.kauan_imovel.infrastructure.mapper;

import com.myProject.kauan_imovel.application.command.venda.CadastrarVendaCommand;
import com.myProject.kauan_imovel.domain.pessoa.PessoaCompradoraEntity;
import com.myProject.kauan_imovel.domain.pessoa.PessoaProprietarioEntity;
import com.myProject.kauan_imovel.domain.pessoa.PessoaVendedoraEntity;
import com.myProject.kauan_imovel.domain.propriedade.PropriedadeEntity;
import com.myProject.kauan_imovel.domain.venda.VendaEntity;
import com.myProject.kauan_imovel.domain.venda.dto.VendaQueryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface VendaMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "propriedades", ignore = true)
    @Mapping(target = "vendedor", ignore = true)
    @Mapping(target = "comprador", ignore = true)
    @Mapping(target = "proprietario", ignore = true)
    VendaEntity toEntity(CadastrarVendaCommand command);

    @Mapping(target = "propriedades", expression = "java(mapPropriedadesIds(entity.getPropriedades()))")
    @Mapping(target = "vendedorId", source = "vendedor.id")
    @Mapping(target = "compradorId", source = "comprador.id")
    @Mapping(target = "proprietarioId", source = "proprietario.id")
    VendaQueryDTO toDTO(VendaEntity entity);

    default VendaEntity toAggregate(
            CadastrarVendaCommand cmd,
            PessoaVendedoraEntity vendedor,
            PessoaCompradoraEntity comprador,
            PessoaProprietarioEntity proprietario,
            List<PropriedadeEntity> propriedades
    ) {
        VendaEntity venda = toEntity(cmd);
        venda.setVendedor(vendedor);
        venda.setComprador(comprador);
        venda.setProprietario(proprietario);
        venda.setPropriedades(propriedades);
        return venda;
    }

    @Named("mapPropriedadesIds")
    default List<Long> mapPropriedadesIds(List<PropriedadeEntity> propriedades) {
        return propriedades == null ? null :
                propriedades.stream()
                        .map(PropriedadeEntity::getId)
                        .collect(Collectors.toList());
    }

}

