package com.myProject.kauan_imovel.pessoa.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "pessoa_proprietario")
public class PessoaProprietarioEntity extends PessoaEntity {
    LocalDate dataCadastro;
    String observacoes;
}
