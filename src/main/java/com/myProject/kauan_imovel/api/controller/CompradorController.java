package com.myProject.kauan_imovel.api.controller;

import com.myProject.kauan_imovel.application.command.handlers.pessoa.CadastrarPessoaCompradoraHandler;
import com.myProject.kauan_imovel.application.command.pessoa.CadastrarPessoaCompradoraCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pessoa-compradora")
@RequiredArgsConstructor
public class CompradorController {
    private final CadastrarPessoaCompradoraHandler cadastrarPessoaCompradoraHandler;

    @PostMapping("cadastrar")
    public void cadastrar(@RequestBody CadastrarPessoaCompradoraCommand command) { this.cadastrarPessoaCompradoraHandler.handle(command); }
}
