package com.myProject.kauan_imovel.application.query.handler.venda;

import com.myProject.kauan_imovel.domain.propriedade.PropriedadeEntity;
import com.myProject.kauan_imovel.domain.venda.VendaEntity;
import com.myProject.kauan_imovel.domain.venda.dto.PrejuizoVendaDTO;
import com.myProject.kauan_imovel.infrastructure.repository.PropriedadeRepository;
import com.myProject.kauan_imovel.infrastructure.repository.VendaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BuscarASomaDeTodosPrejuizosQueryHandler {
    private final VendaRepository vendaRepository;
    private final PropriedadeRepository propriedadeRepository;

    public PrejuizoVendaDTO handle(){
        // PEGANDO O VALOR DE TODAS AS VENDAS
        BigDecimal valorTotalVendas = vendaRepository.valorDeVendas();

        // PEGANDO TODOS OS VALORES DAS PROPRIEDADES QUE ESTÃO NAS VENDAS
        List<PropriedadeEntity> propriedadesDasVendas = new ArrayList<>();
        for (VendaEntity venda : vendaRepository.findAll() ) {
            propriedadesDasVendas.addAll(venda.getPropriedades());
        }
        // PEGANDO OS VALORES
        BigDecimal valorTotalDasPropriedades = BigDecimal.ZERO;

        // LISTA DE PREÇOS DA MINHA PROPRIEDADE PARA EU ESTAR MANDANDO NO RETORNO
        List<BigDecimal> listaPrecos = new ArrayList<>();

        for (PropriedadeEntity propriedade : propriedadesDasVendas) {
            valorTotalDasPropriedades = valorTotalDasPropriedades.add(propriedade.getPrecoPropriedade());
            listaPrecos.add(propriedade.getPrecoPropriedade());
        }

        //OPERAÇÃO
        BigDecimal total = valorTotalVendas.subtract(valorTotalDasPropriedades);
        // DANDO RETORNO
        if(total.compareTo(BigDecimal.ZERO) < 0){
            BigDecimal prejuizos = total.abs();
            return new PrejuizoVendaDTO(
                    listaPrecos,
                    valorTotalVendas,
                    prejuizos
            );
        }

        // SE NÃO TIVER PREJUÍZO, RETORNE NULL
        return null;
    }
}
