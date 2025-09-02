package com.myProject.kauan_imovel.application.query.handler.venda;

import com.myProject.kauan_imovel.domain.venda.VendaEntity;
import com.myProject.kauan_imovel.domain.venda.dto.VendaQueryDTO;
import com.myProject.kauan_imovel.infrastructure.mapper.VendaMapper;
import com.myProject.kauan_imovel.infrastructure.repository.VendaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BuscarVendaPorId {
    private final VendaRepository vendaRepository;
    private final VendaMapper vendaMapper;

    public VendaQueryDTO handle(Long id) {
        VendaEntity entity = vendaRepository.findById(id).get();
        VendaQueryDTO dto = vendaMapper.toDTO(entity);
        return dto;
    }
}
