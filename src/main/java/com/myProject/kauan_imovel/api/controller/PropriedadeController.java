package com.myProject.kauan_imovel.api.controller;

import com.myProject.kauan_imovel.application.command.handlers.propriedade.AlterarPropriedadeHandler;
import com.myProject.kauan_imovel.application.command.handlers.propriedade.CadastrarPropriedadeHandler;
import com.myProject.kauan_imovel.application.command.handlers.propriedade.DeletarPropriedadeHandler;
import com.myProject.kauan_imovel.application.command.propriedade.CadastrarPropriedadeCommand;
import com.myProject.kauan_imovel.application.query.handler.propriedade.BuscarPropriedadePorIdQueryHandler;
import com.myProject.kauan_imovel.application.query.handler.propriedade.BuscarTodasPropriedadesDisponiveisQueryHandler;
import com.myProject.kauan_imovel.application.query.handler.propriedade.BuscarTodasPropriedadesQueryHandler;
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
    private final AlterarPropriedadeHandler alterarPropriedadeHandler;
    private final DeletarPropriedadeHandler deletarPropriedadeHandler;

    // CADASTRAR PROPRIEDADES
    @PostMapping("/cadastrar")
    public ResponseEntity<Void> cadastrar(@RequestBody CadastrarPropriedadeCommand command) {
        cadastrarPropriedadeHandler.handle(command);
        return ResponseEntity.ok().build();
    }

    // LISTAR TODAS AS PROPRIEDADES
    @GetMapping("/listar")
    public ResponseEntity<List<PropriedadeQueryDTO>> listar() { return ResponseEntity.ok().body(buscarTodasPropriedadesQueryHandler.handle());}

    @GetMapping("/listar/{id}")
    public ResponseEntity<PropriedadeQueryDTO> listarPorId(@PathVariable("id") Long id) { return ResponseEntity.ok().body(buscarPropriedadePorIdQueryHandler.handle(id));}

    @GetMapping("/listar/disponivel")
    public ResponseEntity<List<PropriedadeQueryDTO>> listarDisponivel() {return ResponseEntity.ok().body(buscarTodasPropriedadesDisponiveisHandler.handle());}

    @PutMapping("/alterar/{id}")
    public ResponseEntity<Void> alterar(@PathVariable("id") Long id, @RequestBody CadastrarPropriedadeCommand command) {
        alterarPropriedadeHandler.handle(id, command);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
        deletarPropriedadeHandler.handle(id);
        return ResponseEntity.ok().build();
    }
}
