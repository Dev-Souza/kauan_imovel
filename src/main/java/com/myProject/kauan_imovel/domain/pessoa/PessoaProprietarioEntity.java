package com.myProject.kauan_imovel.domain.pessoa;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.myProject.kauan_imovel.domain.propriedade.PropriedadeEntity;
import com.myProject.kauan_imovel.domain.venda.VendaEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "pessoa_proprietario")
public class PessoaProprietarioEntity extends PessoaEntity {
    LocalDate dataCadastro;
    String observacoes;
    @OneToMany(mappedBy = "proprietario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<PropriedadeEntity> propriedades = new ArrayList<>();

    @OneToMany(mappedBy = "proprietario")
    List<VendaEntity> vendas;
}
