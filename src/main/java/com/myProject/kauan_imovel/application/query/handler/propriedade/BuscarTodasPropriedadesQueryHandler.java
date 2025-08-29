package com.myProject.kauan_imovel.application.query.handler.propriedade;

import com.myProject.kauan_imovel.domain.propriedade.PropriedadeEntity;
import com.myProject.kauan_imovel.infrastructure.repository.PropriedadeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BuscarTodasPropriedadesQueryHandler {

    private final PropriedadeRepository propriedadeRepository;

    public List<PropriedadeEntity> handle() {
        return propriedadeRepository.findAll();
    }
}
