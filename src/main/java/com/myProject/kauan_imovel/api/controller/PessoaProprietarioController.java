package com.myProject.kauan_imovel.api.controller;

import com.myProject.kauan_imovel.application.command.command.pessoa.CadastrarPessoaProprietarioCommand;
import com.myProject.kauan_imovel.application.command.command.pessoa.DeletePessoaProprietariaCommand;
import com.myProject.kauan_imovel.application.command.handler.pessoa.CadastrarPessoaProprietarioHandler;
import com.myProject.kauan_imovel.application.command.handler.pessoa.DeletePessoaProprietariaHandler;
import com.myProject.kauan_imovel.application.query.handler.BuscarTodasPessoasProprietariasHandler;
import com.myProject.kauan_imovel.domain.pessoa.dto.PessoaProprietarioQueryDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoa-proprietario")
public class PessoaProprietarioController {
    private final CadastrarPessoaProprietarioHandler cadastrarPessoaProprietarioHandler;
    private final BuscarTodasPessoasProprietariasHandler buscarTodasPessoasProprietariasHandler;
    private final DeletePessoaProprietariaHandler deletePessoaProprietariaHandler;

    public PessoaProprietarioController(CadastrarPessoaProprietarioHandler cadastrarPessoaProprietarioHandler, DeletePessoaProprietariaHandler deletePessoaProprietariaHandler, BuscarTodasPessoasProprietariasHandler buscarTodasPessoasProprietariasHandler) {
        this.cadastrarPessoaProprietarioHandler = cadastrarPessoaProprietarioHandler;
        this.deletePessoaProprietariaHandler = deletePessoaProprietariaHandler;
        this.buscarTodasPessoasProprietariasHandler = buscarTodasPessoasProprietariasHandler;
    }

    // CADASTRAR PESSOA PROPRIETARIA
    @PostMapping("/cadastrar")
    public ResponseEntity<Void> create(@RequestBody CadastrarPessoaProprietarioCommand command){
        cadastrarPessoaProprietarioHandler.handle(command);
        return ResponseEntity.ok().build();
    }

    // BUSCAR TODAS AS PESSOAS PROPRIETÁRIAS
    @GetMapping("/listar")
    public ResponseEntity<List<PessoaProprietarioQueryDTO>> listar(){ return buscarTodasPessoasProprietariasHandler.handle(); }

    // DELETAR PESSOA PROPRIETARIA
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        DeletePessoaProprietariaCommand command = new DeletePessoaProprietariaCommand(id);
        deletePessoaProprietariaHandler.handle(command);
        return ResponseEntity.ok().build();
    }
}
