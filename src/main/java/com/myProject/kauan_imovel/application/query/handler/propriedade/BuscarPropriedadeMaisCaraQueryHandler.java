package com.myProject.kauan_imovel.application.query.handler.propriedade;

import com.myProject.kauan_imovel.domain.propriedade.PropriedadeEntity;
import com.myProject.kauan_imovel.domain.propriedade.dto.PropriedadeQueryDTO;
import com.myProject.kauan_imovel.infrastructure.mapper.PropriedadeMapper;
import com.myProject.kauan_imovel.infrastructure.repository.PropriedadeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BuscarPropriedadeMaisCaraQueryHandler {
    private final PropriedadeRepository propriedadeRepository;
    private final PropriedadeMapper mapper;

    public PropriedadeQueryDTO handle(){
        PropriedadeEntity propriedadeMaisCara = propriedadeRepository.findPropriedadeComMaiorPreco();
        return mapper.toDTO(propriedadeMaisCara);
    }
}
