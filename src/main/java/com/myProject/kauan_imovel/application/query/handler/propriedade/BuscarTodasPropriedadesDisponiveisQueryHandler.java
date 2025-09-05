package com.myProject.kauan_imovel.application.query.handler.propriedade;

import com.myProject.kauan_imovel.domain.propriedade.dto.PropriedadeQueryDTO;
import com.myProject.kauan_imovel.infrastructure.mapper.PropriedadeMapper;
import com.myProject.kauan_imovel.infrastructure.repository.PropriedadeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BuscarTodasPropriedadesDisponiveisQueryHandler {
    private final PropriedadeRepository propriedadeRepository;
    private final PropriedadeMapper mapper;

    public List<PropriedadeQueryDTO> handle(){
        List<PropriedadeQueryDTO> propriedades = propriedadeRepository.findAllDisponivelQuery()
                .stream()
                .map(mapper::toDTO)
                .toList();
        return propriedades;
    }
}
