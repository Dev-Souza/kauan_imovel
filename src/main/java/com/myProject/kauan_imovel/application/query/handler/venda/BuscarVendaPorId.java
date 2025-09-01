package com.myProject.kauan_imovel.application.query.handler.venda;

import com.myProject.kauan_imovel.domain.venda.VendaEntity;
import com.myProject.kauan_imovel.infrastructure.repository.VendaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BuscarVendaPorId {
    private final VendaRepository vendaRepository;

    public VendaEntity handle(Long id) {
        return vendaRepository.findById(id).orElse(null);
    }
}
