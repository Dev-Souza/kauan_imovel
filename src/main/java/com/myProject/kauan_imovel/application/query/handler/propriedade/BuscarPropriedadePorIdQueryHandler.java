package com.myProject.kauan_imovel.application.query.handler.propriedade;

import com.myProject.kauan_imovel.domain.propriedade.PropriedadeEntity;
import com.myProject.kauan_imovel.infrastructure.repository.PropriedadeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BuscarPropriedadePorIdQueryHandler {

    private final PropriedadeRepository repository;

    public PropriedadeEntity handle(Long id) {
        if(repository.existsById(id)) return repository.findById(id).get();
        return null;
    }
}
