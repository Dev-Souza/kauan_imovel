package com.myProject.kauan_imovel.application.command.handlers.venda;

import com.myProject.kauan_imovel.application.command.venda.CadastrarVendaCommand;
import com.myProject.kauan_imovel.domain.venda.VendaEntity;
import com.myProject.kauan_imovel.infrastructure.mapper.VendaMapper;
import com.myProject.kauan_imovel.infrastructure.repository.*;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AlterarVendaHandler {
    private final VendaRepository vendaRepository;
    private final PessoaProprietarioRepository pessoaProprietarioRepository;
    private final PessoaVendedoraRepository pessoaVendedoraRepository;
    private final PessoaCompradoraRepository pessoaCompradoraRepository;
    private final PropriedadeRepository propriedadeRepository;
    private final VendaMapper mapper;

    @Transactional
    public void handle(Long vendaId, CadastrarVendaCommand command) {
        // 1) Carrega a venda existente (404 se não existir)
        VendaEntity venda = vendaRepository.findById(vendaId)
                .orElseThrow(() -> new EntityNotFoundException("Venda não encontrada" + vendaId));

        // 2) Copia campos "simples" (Sem mexer nas PKs e FKs)
        mapper.copy(venda, command);

        // 3) Proprietário (obrigatório no PUT) — valida existência
        var vendedor = pessoaVendedoraRepository.findById(command.vendedorId())
                .orElseThrow(() -> new EntityNotFoundException("Vendedor não encontrado: " + command.vendedorId()));
        venda.setVendedor(vendedor);

        var comprador = pessoaCompradoraRepository.findById(command.compradorId())
                .orElseThrow(() -> new EntityNotFoundException("Comprador não encontrado: " + command.compradorId()));
        venda.setComprador(comprador);

        var proprietario = pessoaProprietarioRepository.findById(command.proprietarioId())
                .orElseThrow(() -> new EntityNotFoundException("Proprietário não encontrado: " + command.proprietarioId()));
        venda.setProprietario(proprietario);

        var propriedades = propriedadeRepository.findAllById(command.propriedades());
        venda.setPropriedades(propriedades);

        vendaRepository.save(venda);
    }
}
