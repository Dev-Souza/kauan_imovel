package com.myProject.kauan_imovel.domain.pessoa;

import com.myProject.kauan_imovel.domain.venda.VendaEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "pessoa_compradora")
public class PessoaCompradoraEntity extends PessoaEntity{

    private BigDecimal faixaPrecoDesejada;
    private boolean possuiFinanciamentoAprovado;
    private String instituicaoFinanceira;
    @OneToMany(mappedBy = "comprador")
    List<VendaEntity> compras;
}
