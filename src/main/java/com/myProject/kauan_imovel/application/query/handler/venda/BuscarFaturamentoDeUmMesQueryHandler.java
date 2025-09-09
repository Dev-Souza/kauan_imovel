package com.myProject.kauan_imovel.application.query.handler.venda;

import com.myProject.kauan_imovel.application.exceptions.MesInvalidoException;
import com.myProject.kauan_imovel.domain.venda.dto.FaturamentoVendaDTO;
import com.myProject.kauan_imovel.infrastructure.mapper.VendaMapper;
import com.myProject.kauan_imovel.infrastructure.repository.VendaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class BuscarFaturamentoDeUmMesQueryHandler {
    private final VendaRepository vendaRepository;
    private final VendaMapper vendaMapper;

    public FaturamentoVendaDTO handle(Integer mes){
        if(mes <= 0 || mes > 12){
            throw new MesInvalidoException("Mês inválido!");
        }
        return vendaRepository.buscarFaturamentoDeUmMes(mes);
    }
}
