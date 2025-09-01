package com.myProject.kauan_imovel.api.controller;

import com.myProject.kauan_imovel.application.command.handlers.pessoa.CadastrarPessoaCompradoraHandler;
import com.myProject.kauan_imovel.application.command.pessoa.CadastrarPessoaCompradoraCommand;
import com.myProject.kauan_imovel.application.query.handler.pessoa.BuscarCompradorPorIdHandler;
import com.myProject.kauan_imovel.application.query.handler.pessoa.BuscarTodosCompradoresHandler;
import com.myProject.kauan_imovel.domain.pessoa.dto.PessoaCompradoraQueryDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoa-compradora")
@RequiredArgsConstructor
public class CompradorController {
    private final CadastrarPessoaCompradoraHandler cadastrarPessoaCompradoraHandler;
    private final BuscarTodosCompradoresHandler buscarTodosCompradoresHandler;
    private final BuscarCompradorPorIdHandler buscarCompradorPorIdHandler;

    @PostMapping("/cadastrar")
    public void cadastrar(@RequestBody CadastrarPessoaCompradoraCommand command) { this.cadastrarPessoaCompradoraHandler.handle(command); }

    @GetMapping("/listar")
    public ResponseEntity<List<PessoaCompradoraQueryDTO>> listar() {return ResponseEntity.ok().body(this.buscarTodosCompradoresHandler.handle());}

    @GetMapping("/listar/{id}")
    public ResponseEntity<PessoaCompradoraQueryDTO> listarPorId(@PathVariable("id") Long id) {return ResponseEntity.ok().body(this.buscarCompradorPorIdHandler.handle(id));}
}
