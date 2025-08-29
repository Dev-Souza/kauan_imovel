package com.myProject.kauan_imovel.api.controller;

import com.myProject.kauan_imovel.application.command.pessoa.CadastrarPessoaVendedoraCommand;
import com.myProject.kauan_imovel.application.command.handlers.pessoa.AlterarPessoaVendedoraHandler;
import com.myProject.kauan_imovel.application.command.handlers.pessoa.CadastrarPessoaVendedoraHandler;
import com.myProject.kauan_imovel.application.command.handlers.pessoa.DeletePessoaVendedoraHandler;
import com.myProject.kauan_imovel.application.query.handler.pessoa.BuscarPessoaVendedoraPorIdHandler;
import com.myProject.kauan_imovel.application.query.handler.pessoa.BuscarTodosVendedoresHandler;
import com.myProject.kauan_imovel.domain.pessoa.dto.PessoaVendedoraQueryDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoa-vendedora")
public class VendedorController {
    private final CadastrarPessoaVendedoraHandler cadastrarPessoaVendedoraHandler;
    private final BuscarTodosVendedoresHandler buscarTodosVendedoresHandler;
    private final BuscarPessoaVendedoraPorIdHandler buscarPessoaVendedoraPorIdHandler;
    private final AlterarPessoaVendedoraHandler alterarPessoaVendedoraHandler;
    private final DeletePessoaVendedoraHandler deletePessoaVendedoraHandler;

    public VendedorController(CadastrarPessoaVendedoraHandler cadastrarPessoaVendedoraHandler, BuscarTodosVendedoresHandler buscarTodosVendedoresHandler, BuscarPessoaVendedoraPorIdHandler buscarPessoaVendedoraPorIdHandler, AlterarPessoaVendedoraHandler alterarPessoaVendedoraHandler, DeletePessoaVendedoraHandler deletePessoaVendedoraHandler) {
        this.cadastrarPessoaVendedoraHandler = cadastrarPessoaVendedoraHandler;
        this.buscarTodosVendedoresHandler = buscarTodosVendedoresHandler;
        this.buscarPessoaVendedoraPorIdHandler = buscarPessoaVendedoraPorIdHandler;
        this.alterarPessoaVendedoraHandler = alterarPessoaVendedoraHandler;
        this.deletePessoaVendedoraHandler = deletePessoaVendedoraHandler;
    }

    // CADASTRAR VENDEDOR
    @PostMapping("/cadastrar")
    public ResponseEntity<Void> cadastrarPessoaVendedora(@RequestBody CadastrarPessoaVendedoraCommand command) {
        cadastrarPessoaVendedoraHandler.handle(command);
        return ResponseEntity.ok().build();
    }

    // BUSCAR TODOS OS VENDEDORES
    @GetMapping("/listar")
    public ResponseEntity<List<PessoaVendedoraQueryDTO>> listar(){return buscarTodosVendedoresHandler.handle();}

    // BUSCAR VENDEDOR POR ID
    @GetMapping("/listar/{id}")
    public ResponseEntity<PessoaVendedoraQueryDTO> listarPorId(@PathVariable("id") Long id){
        PessoaVendedoraQueryDTO pessoa =  buscarPessoaVendedoraPorIdHandler.handle(id);
        return ResponseEntity.ok().body(pessoa);
    }

    // ALTERAR VENDEDOR
    @PutMapping("/alterar/{id}")
    public ResponseEntity<Void> update(@PathVariable("id") Long id, @RequestBody CadastrarPessoaVendedoraCommand command){
        alterarPessoaVendedoraHandler.handle(id, command);
        return ResponseEntity.ok().build();
    }

    // DELETAR VENDEDOR
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        deletePessoaVendedoraHandler.handle(id);
        return ResponseEntity.ok().build();
    }
}
