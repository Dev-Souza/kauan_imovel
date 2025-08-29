package com.myProject.kauan_imovel.api.controller;

import com.myProject.kauan_imovel.application.command.handlers.propriedade.CadastrarPropriedadeHandler;
import com.myProject.kauan_imovel.application.command.propriedade.CadastrarPropriedadeCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/propriedade")
@RequiredArgsConstructor
public class PropriedadeController {
    private final CadastrarPropriedadeHandler cadastrarPropriedadeHandler;

    @PostMapping("/cadastrar")
    public ResponseEntity<Void> cadastrar(@RequestBody CadastrarPropriedadeCommand command) {
        cadastrarPropriedadeHandler.handle(command);
        return ResponseEntity.ok().build();
    }
}
