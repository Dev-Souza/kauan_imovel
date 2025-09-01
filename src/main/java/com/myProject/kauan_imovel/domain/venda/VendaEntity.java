package com.myProject.kauan_imovel.domain.venda;

import com.myProject.kauan_imovel.domain.pessoa.PessoaCompradoraEntity;
import com.myProject.kauan_imovel.domain.pessoa.PessoaVendedoraEntity;
import com.myProject.kauan_imovel.domain.propriedade.PropriedadeEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "venda")
public class VendaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dataVenda;
    private BigDecimal valorVenda;
    @Enumerated(EnumType.STRING)
    FormaPagamentoEnum formaPagamento;

    @ManyToMany
    @JoinTable(name = "venda_propriedade",
        joinColumns = @JoinColumn(name = "venda_id"),
        inverseJoinColumns = @JoinColumn(name = "propriedade_id"))
    private List<PropriedadeEntity> propriedades;

    @ManyToOne
    @JoinColumn(name = "vendedor_id", nullable = false)
    private PessoaVendedoraEntity vendedor;

    @ManyToOne
    @JoinColumn(name = "comprador_id")
    private PessoaCompradoraEntity comprador;
}
