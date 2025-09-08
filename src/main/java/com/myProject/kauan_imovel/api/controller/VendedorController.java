package com.myProject.kauan_imovel.api.controller;

import com.myProject.kauan_imovel.application.command.pessoa.CadastrarPessoaVendedoraCommand;
import com.myProject.kauan_imovel.application.command.handlers.pessoa.AlterarPessoaVendedoraHandler;
import com.myProject.kauan_imovel.application.command.handlers.pessoa.CadastrarPessoaVendedoraHandler;
import com.myProject.kauan_imovel.application.command.handlers.pessoa.DeletePessoaVendedoraHandler;
import com.myProject.kauan_imovel.application.query.handler.pessoa.BuscarPessoaVendedoraPorIdHandler;
import com.myProject.kauan_imovel.application.query.handler.pessoa.BuscarTodosVendedoresHandler;
import com.myProject.kauan_imovel.application.query.handler.pessoa.BuscarVendedorQueMaisVendeuEmUmTempo;
import com.myProject.kauan_imovel.domain.pessoa.PessoaVendedoraEntity;
import com.myProject.kauan_imovel.domain.pessoa.dto.BuscarVendedorQueMaisVendeuEmUmTempoDTO;
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
    private final BuscarVendedorQueMaisVendeuEmUmTempo buscarVendedorQueMaisVendeuEmUmTempo;

    public VendedorController(CadastrarPessoaVendedoraHandler cadastrarPessoaVendedoraHandler, BuscarTodosVendedoresHandler buscarTodosVendedoresHandler, BuscarPessoaVendedoraPorIdHandler buscarPessoaVendedoraPorIdHandler, AlterarPessoaVendedoraHandler alterarPessoaVendedoraHandler, DeletePessoaVendedoraHandler deletePessoaVendedoraHandler, BuscarVendedorQueMaisVendeuEmUmTempo buscarVendedorQueMaisVendeuEmUmTempo) {
        this.cadastrarPessoaVendedoraHandler = cadastrarPessoaVendedoraHandler;
        this.buscarTodosVendedoresHandler = buscarTodosVendedoresHandler;
        this.buscarPessoaVendedoraPorIdHandler = buscarPessoaVendedoraPorIdHandler;
        this.alterarPessoaVendedoraHandler = alterarPessoaVendedoraHandler;
        this.deletePessoaVendedoraHandler = deletePessoaVendedoraHandler;
        this.buscarVendedorQueMaisVendeuEmUmTempo = buscarVendedorQueMaisVendeuEmUmTempo;
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

    @GetMapping("/buscar-vendedor-que-mais-vendeu-em-um-tempo")
    public PessoaVendedoraEntity buscar(@RequestBody BuscarVendedorQueMaisVendeuEmUmTempoDTO filtro) { return buscarVendedorQueMaisVendeuEmUmTempo.handle(filtro.getDataInicial(), filtro.getDataFinal());}
}
