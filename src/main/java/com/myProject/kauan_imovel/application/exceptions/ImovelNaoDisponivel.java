package com.myProject.kauan_imovel.application.exceptions;

public class ImovelNaoDisponivel extends RuntimeException {
    public ImovelNaoDisponivel(String message) {
        super(message);
    }
}
