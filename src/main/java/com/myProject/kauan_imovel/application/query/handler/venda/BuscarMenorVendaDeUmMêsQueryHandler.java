package com.myProject.kauan_imovel.application.query.handler.venda;

import com.myProject.kauan_imovel.application.exceptions.MesInvalidoException;
import com.myProject.kauan_imovel.domain.venda.VendaEntity;
import com.myProject.kauan_imovel.domain.venda.dto.VendaQueryDTO;
import com.myProject.kauan_imovel.infrastructure.mapper.VendaMapper;
import com.myProject.kauan_imovel.infrastructure.repository.VendaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BuscarMenorVendaDeUmMêsQueryHandler {
    private final VendaRepository vendaRepository;
    private final VendaMapper vendaMapper;

    public VendaQueryDTO handle(Integer mes){
        if(mes <= 0 || mes > 12){
            throw new MesInvalidoException("Mês inválido!");
        }
        VendaEntity menorVenda = vendaRepository.buscarMenorVendaDeUmMes(mes);
        return vendaMapper.toDTO(menorVenda);
    }
}
