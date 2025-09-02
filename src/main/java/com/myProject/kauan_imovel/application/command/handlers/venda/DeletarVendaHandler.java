package com.myProject.kauan_imovel.application.command.handlers.venda;

import com.myProject.kauan_imovel.infrastructure.repository.VendaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeletarVendaHandler {

    private final VendaRepository vendaRepository;

    public void handle(Long id) {
        if(vendaRepository.existsById(id)) {
            vendaRepository.deleteById(id);
        }
    }
}
