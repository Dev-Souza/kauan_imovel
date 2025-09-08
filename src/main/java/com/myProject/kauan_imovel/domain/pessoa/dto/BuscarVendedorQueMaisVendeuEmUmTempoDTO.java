package com.myProject.kauan_imovel.domain.pessoa.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class BuscarVendedorQueMaisVendeuEmUmTempoDTO {
    private LocalDate dataInicial;
    private LocalDate dataFinal;
}
