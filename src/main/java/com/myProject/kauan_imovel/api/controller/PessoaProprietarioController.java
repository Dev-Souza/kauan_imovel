package com.myProject.kauan_imovel.api.controller;

import com.myProject.kauan_imovel.application.command.command.pessoa.CadastrarPessoaProprietarioCommand;
import com.myProject.kauan_imovel.application.command.handler.pessoa.CadastrarPessoaProprietarioHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pessoa-proprietario")
public class PessoaProprietarioController {
    private final CadastrarPessoaProprietarioHandler cadastrarPessoaProprietarioHandler;

    public PessoaProprietarioController(CadastrarPessoaProprietarioHandler cadastrarPessoaProprietarioHandler) {
        this.cadastrarPessoaProprietarioHandler = cadastrarPessoaProprietarioHandler;
    }

    // CADASTRAR PESSOA PROPRIETARIA
    @PostMapping
    public ResponseEntity<Void> create(@RequestBody CadastrarPessoaProprietarioCommand command){
        cadastrarPessoaProprietarioHandler.handle(command);
        return ResponseEntity.ok().build();
    }
}
