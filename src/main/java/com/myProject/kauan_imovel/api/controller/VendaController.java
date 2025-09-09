package com.myProject.kauan_imovel.api.controller;

import com.myProject.kauan_imovel.application.command.handlers.venda.AlterarVendaHandler;
import com.myProject.kauan_imovel.application.command.handlers.venda.CadastrarVendaHandler;
import com.myProject.kauan_imovel.application.command.handlers.venda.DeletarVendaHandler;
import com.myProject.kauan_imovel.application.command.venda.CadastrarVendaCommand;
import com.myProject.kauan_imovel.application.query.handler.venda.BuscarMaiorVendaDeUmMêsQueryHandler;
import com.myProject.kauan_imovel.application.query.handler.venda.BuscarMenorVendaDeUmMêsQueryHandler;
import com.myProject.kauan_imovel.application.query.handler.venda.BuscarTodasVendasHandler;
import com.myProject.kauan_imovel.application.query.handler.venda.BuscarVendaPorId;
import com.myProject.kauan_imovel.domain.venda.dto.VendaQueryDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/venda")
@RequiredArgsConstructor
public class VendaController {
    private final CadastrarVendaHandler cadastrarVendaHandler;
    private final BuscarTodasVendasHandler buscarTodasVendasHandler;
    private final BuscarVendaPorId buscarVendaPorId;
    private final AlterarVendaHandler alterarVendaHandler;
    private final DeletarVendaHandler deletarVendaHandler;
    private final BuscarMaiorVendaDeUmMêsQueryHandler buscarMaiorVendaDeUmMmsQueryHandler;
    private final BuscarMenorVendaDeUmMêsQueryHandler buscarMenorVendaDeUmMmsQueryHandler;

    @PostMapping("/cadastrar")
    public void cadastrarVenda(@RequestBody CadastrarVendaCommand command) {this.cadastrarVendaHandler.handle(command);}

    @GetMapping("/listar")
    public ResponseEntity<List<VendaQueryDTO>> listarVendas() {return ResponseEntity.ok().body(this.buscarTodasVendasHandler.handle());}

    @GetMapping("/listar/{id}")
    public ResponseEntity<VendaQueryDTO> listarVendaPorId(@PathVariable("id") Long id) {return ResponseEntity.ok().body(this.buscarVendaPorId.handle(id));}

    @PutMapping("/alterar/{id}")
    public void alterar(@PathVariable("id") Long id, @RequestBody CadastrarVendaCommand command) {this.alterarVendaHandler.handle(id, command);}

    @DeleteMapping("/deletar/{id}")
    public void deletar(@PathVariable("id") Long id) {this.deletarVendaHandler.handle(id);}

    @GetMapping("/listar/maior/{mes}")
    public ResponseEntity<VendaQueryDTO> listarMaiorVenda(@PathVariable("mes") Integer mes) {return ResponseEntity.ok().body(buscarMaiorVendaDeUmMmsQueryHandler.handle(mes));}

    @GetMapping("/listar/menor/{mes}")
    public ResponseEntity<VendaQueryDTO> listarMenorVenda(@PathVariable("mes") Integer mes) {return ResponseEntity.ok().body(buscarMenorVendaDeUmMmsQueryHandler.handle(mes));}
}
