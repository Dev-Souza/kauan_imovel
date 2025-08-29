package com.myProject.kauan_imovel.api.controller;

import com.myProject.kauan_imovel.application.command.handlers.propriedade.CadastrarPropriedadeHandler;
import com.myProject.kauan_imovel.application.command.propriedade.CadastrarPropriedadeCommand;
import com.myProject.kauan_imovel.application.query.handler.propriedade.BuscarPropriedadePorIdQueryHandler;
import com.myProject.kauan_imovel.application.query.handler.propriedade.BuscarTodasPropriedadesQueryHandler;
import com.myProject.kauan_imovel.domain.propriedade.PropriedadeEntity;
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

    // CADASTRAR PROPRIEDADES
    @PostMapping("/cadastrar")
    public ResponseEntity<Void> cadastrar(@RequestBody CadastrarPropriedadeCommand command) {
        cadastrarPropriedadeHandler.handle(command);
        return ResponseEntity.ok().build();
    }

    // LISTAR TODAS AS PROPRIEDADES
    @GetMapping("/listar")
    public ResponseEntity<List<PropriedadeEntity>> listar() { return ResponseEntity.ok().body(buscarTodasPropriedadesQueryHandler.handle());}

    @GetMapping("/listar/{id}")
    public ResponseEntity<PropriedadeEntity> listarPorId(@PathVariable("id") Long id) { return ResponseEntity.ok().body(buscarPropriedadePorIdQueryHandler.handle(id));}


}
