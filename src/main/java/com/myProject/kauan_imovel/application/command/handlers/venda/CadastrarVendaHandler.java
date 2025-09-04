package com.myProject.kauan_imovel.application.command.handlers.venda;

import com.myProject.kauan_imovel.application.command.venda.CadastrarVendaCommand;
import com.myProject.kauan_imovel.application.exceptions.ImovelNaoDisponivel;
import com.myProject.kauan_imovel.domain.propriedade.PropriedadeEntity;
import com.myProject.kauan_imovel.domain.venda.VendaEntity;
import com.myProject.kauan_imovel.infrastructure.mapper.VendaMapper;
import com.myProject.kauan_imovel.infrastructure.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class CadastrarVendaHandler {
    private final VendaRepository vendaRepository;
    private final PessoaProprietarioRepository pessoaProprietarioRepository;
    private final PessoaVendedoraRepository pessoaVendedoraRepository;
    private final PessoaCompradoraRepository pessoaCompradoraRepository;
    private final PropriedadeRepository propriedadeRepository;
    private final VendaMapper mapper;

    public void handle(CadastrarVendaCommand command) {
        // Buscando vendedor
        var pessoaVendedor = pessoaVendedoraRepository.getReferenceById(command.vendedorId());

        // Buscando Comprador
        var pessoaCompradora = pessoaCompradoraRepository.getReferenceById(command.compradorId());

        // Buscando Proprietario
        var pessoaProprietario = pessoaProprietarioRepository.getReferenceById(command.proprietarioId());

        // Buscando propriedades
        var propriedades = propriedadeRepository.findAllById(command.propriedades());

        for (PropriedadeEntity entity : propriedades) {
            if(entity.isDisponivel()){
                propriedadeRepository.alterarDiponibilidadeDoImovel(entity.getId());
            } else {
                throw new ImovelNaoDisponivel("Imóvel não esta disponível para venda!");
            }
        }
        VendaEntity prop = mapper.toAggregate(command, pessoaVendedor, pessoaCompradora, pessoaProprietario, propriedades);
        // Persistindo
        vendaRepository.save(prop);
    }
}
