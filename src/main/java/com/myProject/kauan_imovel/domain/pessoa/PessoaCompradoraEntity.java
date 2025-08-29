package com.myProject.kauan_imovel.domain.pessoa;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "pessoa_compradora")
public class PessoaCompradoraEntity extends PessoaEntity{


}
