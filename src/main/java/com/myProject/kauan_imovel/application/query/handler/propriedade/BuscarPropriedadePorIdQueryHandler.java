package com.myProject.kauan_imovel.application.query.handler.propriedade;

import com.myProject.kauan_imovel.domain.propriedade.dto.PropriedadeQueryDTO;
import com.myProject.kauan_imovel.infrastructure.mapper.PropriedadeMapper;
import com.myProject.kauan_imovel.infrastructure.repository.PropriedadeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BuscarPropriedadePorIdQueryHandler {

    private final PropriedadeRepository propriedadeRepository;
    private final PropriedadeMapper propriedadeMapper;

    public PropriedadeQueryDTO handle(Long id) {
        Optional<PropriedadeQueryDTO> propriedadeBuscada = propriedadeRepository.findById(id)
                .map(propriedadeMapper::toDTO);
        return propriedadeBuscada.get();
    }
}
