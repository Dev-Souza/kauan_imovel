package com.myProject.kauan_imovel.domain.pessoa;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.myProject.kauan_imovel.domain.venda.VendaEntity;
import jakarta.persistence.*;
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
    private Boolean possuiFinanciamentoAprovado;
    private String instituicaoFinanceira;
    @OneToMany(mappedBy = "comprador", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    List<VendaEntity> compras;
}
