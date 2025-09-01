package com.myProject.kauan_imovel.application.query.handler.venda;

import com.myProject.kauan_imovel.domain.venda.VendaEntity;
import com.myProject.kauan_imovel.domain.venda.dto.VendaQueryDTO;
import com.myProject.kauan_imovel.infrastructure.mapper.VendaMapper;
import com.myProject.kauan_imovel.infrastructure.repository.VendaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BuscarTodasVendasHandler {
    private final VendaRepository vendaRepository;
    private final VendaMapper vendaMapper;

    public List<VendaEntity> handle() {
        return vendaRepository.findAll();
    }
}
