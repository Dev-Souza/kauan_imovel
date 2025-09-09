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
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BuscarPrejuizosEmVendasQueryHandler {
    private final VendaRepository vendaRepository;
    private final PropriedadeRepository propriedadeRepository;

    public PrejuizoVendaDTO handle(Long vendaId) {
        Optional<VendaEntity> vendaEntity = vendaRepository.findById(vendaId);
        if (vendaEntity.isPresent()) {
            // BUSCAR A PROPRIEDADE PARA FAZER AS CONTAS DOS VALORES
            List<PropriedadeEntity> propriedades = new ArrayList<>();

            //Iniciando a variavel de prejuízo
            BigDecimal prejuizo = BigDecimal.ZERO;

            //Iniciando a variavel valor venda
            BigDecimal valorVenda = vendaEntity.get().getValorVenda();

            for (PropriedadeEntity propriedade : vendaEntity.get().getPropriedades()) {
                Optional<PropriedadeEntity> propriedadeBuscada = propriedadeRepository.findById(propriedade.getId());
                // CASO FOR PRESENTE AS PROPRIEDADES ENVOLVIDAS NAS VENDAS, ADD NA LISTA
                propriedadeBuscada.ifPresent(propriedades::add);
            }

            for (PropriedadeEntity propriedade : propriedades) {
                BigDecimal precoPropriedade = propriedade.getPrecoPropriedade();
                valorVenda = valorVenda.subtract(precoPropriedade);
            }

            // FOR PARA ADD OS PRECOS DAS PROPRIEDADES
            List<BigDecimal> listaPrecos = new ArrayList<>();
            for (PropriedadeEntity Ids : propriedades) listaPrecos.add(Ids.getPrecoPropriedade());

            // COMPARANDO PARA VER SE TEVE PREJUÍZO
            if (valorVenda.compareTo(BigDecimal.ZERO) < 0) {
                prejuizo = valorVenda.abs(); // pega o valor absoluto do prejuízo
                // MONTANDO A RESPOSTA
                return new PrejuizoVendaDTO(
                        listaPrecos,
                        vendaEntity.get().getValorVenda(),
                        prejuizo
                );
            }
        } else throw new RuntimeException("Venda não encontrada");

        return null;
    }
}
