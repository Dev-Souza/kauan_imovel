package com.myProject.kauan_imovel.api.controller;

import com.myProject.kauan_imovel.application.command.handlers.propriedade.AlterarPropriedadeHandler;
import com.myProject.kauan_imovel.application.command.handlers.propriedade.CadastrarPropriedadeHandler;
import com.myProject.kauan_imovel.application.command.handlers.propriedade.DeletarPropriedadeHandler;
import com.myProject.kauan_imovel.application.command.propriedade.CadastrarPropriedadeCommand;
import com.myProject.kauan_imovel.application.query.handler.propriedade.*;
import com.myProject.kauan_imovel.domain.propriedade.dto.PropriedadeQueryDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/propriedade")
@RequiredArgsConstructor
public class PropriedadeController {
    private final CadastrarPropriedadeHandler cadastrarPropriedadeHandler;
    private final BuscarTodasPropriedadesQueryHandler buscarTodasPropriedadesQueryHandler;
    private final BuscarPropriedadePorIdQueryHandler buscarPropriedadePorIdQueryHandler;
    private final BuscarTodasPropriedadesDisponiveisQueryHandler buscarTodasPropriedadesDisponiveisHandler;
    private final BuscarPropriedadeMaisCaraQueryHandler buscarPropriedadeMaisCaraQueryHandler;
    private final BuscarPropriedadeMaisBarataQueryHandler buscarPropriedadeMaisBarataQueryHandler;
    private final BuscarPropriedadePorNomeQueryHandler buscarPropriedadePorNomeQueryHandler;
    private final AlterarPropriedadeHandler alterarPropriedadeHandler;
    private final DeletarPropriedadeHandler deletarPropriedadeHandler;

    // CADASTRAR PROPRIEDADES
    @PostMapping("/cadastrar")
    public void cadastrar(@RequestBody CadastrarPropriedadeCommand command) {cadastrarPropriedadeHandler.handle(command);}

    // LISTAR TODAS AS PROPRIEDADES
    @GetMapping("/listar")
    public ResponseEntity<List<PropriedadeQueryDTO>> listar() { return ResponseEntity.ok().body(buscarTodasPropriedadesQueryHandler.handle());}

    @GetMapping("/listar/{id}")
    public ResponseEntity<PropriedadeQueryDTO> listarPorId(@PathVariable("id") Long id) { return ResponseEntity.ok().body(buscarPropriedadePorIdQueryHandler.handle(id));}

    @GetMapping("/listar/disponivel")
    public ResponseEntity<List<PropriedadeQueryDTO>> listarDisponivel() {return ResponseEntity.ok().body(buscarTodasPropriedadesDisponiveisHandler.handle());}

    @GetMapping("/listar/mais-cara")
    public ResponseEntity<PropriedadeQueryDTO> listarMaisCara() {return ResponseEntity.ok().body(buscarPropriedadeMaisCaraQueryHandler.handle());}

    @GetMapping("/listar/mais-barata")
    public ResponseEntity<PropriedadeQueryDTO> listarMaisBarato() {return ResponseEntity.ok().body(buscarPropriedadeMaisBarataQueryHandler.handle());}

    @GetMapping("/listar/nome/{nome}")
    public ResponseEntity<List<PropriedadeQueryDTO>> listarPropriedadesPorNome(@PathVariable("nome") String nome) {return ResponseEntity.ok().body(buscarPropriedadePorNomeQueryHandler.handler(nome));}

    @PutMapping("/alterar/{id}")
    public void alterar(@PathVariable("id") Long id, @RequestBody CadastrarPropriedadeCommand command) {alterarPropriedadeHandler.handle(id, command);}

    @DeleteMapping("/deletar/{id}")
    public void deletar(@PathVariable("id") Long id) {deletarPropriedadeHandler.handle(id);}
}
