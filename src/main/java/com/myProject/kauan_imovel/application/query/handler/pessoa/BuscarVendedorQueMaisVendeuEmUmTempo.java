package com.myProject.kauan_imovel.application.query.handler.pessoa;

import com.myProject.kauan_imovel.domain.pessoa.PessoaVendedoraEntity;
import com.myProject.kauan_imovel.infrastructure.repository.PessoaVendedoraRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class BuscarVendedorQueMaisVendeuEmUmTempo {
    private final PessoaVendedoraRepository repository;

    public PessoaVendedoraEntity handle(LocalDate dataInicial, LocalDate dataFinal) {
        return repository.vendedorQueMaisVendeu(dataInicial, dataFinal);
    }
}
