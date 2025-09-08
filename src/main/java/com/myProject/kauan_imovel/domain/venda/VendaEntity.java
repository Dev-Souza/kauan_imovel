package com.myProject.kauan_imovel.domain.venda;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.myProject.kauan_imovel.domain.pessoa.PessoaCompradoraEntity;
import com.myProject.kauan_imovel.domain.pessoa.PessoaProprietarioEntity;
import com.myProject.kauan_imovel.domain.pessoa.PessoaVendedoraEntity;
import com.myProject.kauan_imovel.domain.propriedade.PropriedadeEntity;
import com.myProject.kauan_imovel.domain.venda.dto.VendaDTO;
import com.myProject.kauan_imovel.domain.venda.dto.VendaQueryDTO;
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
    @JsonBackReference
    private PessoaCompradoraEntity comprador;

    @ManyToOne
    @JoinColumn(name = "proprietario_id")
    private PessoaProprietarioEntity proprietario;


    public VendaDTO toDTO() {
        return new VendaDTO(
                this.getId(),
                this.getDataVenda(),
                this.getValorVenda(),
                this.getFormaPagamento(),
                this.getPropriedades().stream().map(PropriedadeEntity::getId).toList(),
                this.getVendedor().getId(),
                this.getProprietario().getId()
        );
    }

}
