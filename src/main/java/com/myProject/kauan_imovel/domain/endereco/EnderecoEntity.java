package com.myProject.kauan_imovel.domain.endereco;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.myProject.kauan_imovel.domain.propriedade.PropriedadeEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "endereco")
public class EnderecoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cep;
    private String logradouro;
    private String localidade;
    private String uf;
    private String bairro;

    @OneToOne
    @JoinColumn(name = "propriedade_id", nullable = false, unique = true)
    @JsonBackReference
    private PropriedadeEntity propriedade;
}
