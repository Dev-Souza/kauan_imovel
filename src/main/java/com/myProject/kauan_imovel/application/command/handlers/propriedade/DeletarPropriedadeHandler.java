package com.myProject.kauan_imovel.application.command.handlers.propriedade;

import com.myProject.kauan_imovel.infrastructure.repository.PropriedadeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeletarPropriedadeHandler {

    private final PropriedadeRepository propriedadeRepository;

    public void handle(Long id) {
        if(propriedadeRepository.existsById(id)) {
            propriedadeRepository.deleteById(id);
        }
    }
}
