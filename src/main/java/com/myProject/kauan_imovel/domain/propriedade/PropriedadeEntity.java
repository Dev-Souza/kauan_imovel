package com.myProject.kauan_imovel.domain.propriedade;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.myProject.kauan_imovel.domain.endereco.EnderecoEntity;
import com.myProject.kauan_imovel.domain.pessoa.PessoaProprietarioEntity;
import com.myProject.kauan_imovel.domain.venda.VendaEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "propriedade")
public class PropriedadeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    @Enumerated(EnumType.STRING)
    private TipoPropriedadeEnum tipoPropriedade;
    private double areaPropriedade;
    private Integer numeroQuartos;
    private Integer numeroBanheiros;
    private BigDecimal precoPropriedade;
    private boolean disponivel;

    @ManyToOne
    @JoinColumn(name = "proprietario_id", nullable = false)
    private PessoaProprietarioEntity proprietario;

    @OneToOne(mappedBy = "propriedade", cascade = CascadeType.ALL, orphanRemoval = true, optional = false)
    private EnderecoEntity endereco;

    @ManyToMany(mappedBy = "propriedades")
    private List<VendaEntity> vendas;

    public void definirEndereco(EnderecoEntity e) {
        this.endereco = e;
        if (e != null) e.setPropriedade(this);
    }
}
