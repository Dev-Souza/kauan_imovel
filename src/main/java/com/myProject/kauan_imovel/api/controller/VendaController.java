package com.myProject.kauan_imovel.api.controller;

import com.myProject.kauan_imovel.application.command.handlers.venda.AlterarVendaHandler;
import com.myProject.kauan_imovel.application.command.handlers.venda.CadastrarVendaHandler;
import com.myProject.kauan_imovel.application.command.handlers.venda.DeletarVendaHandler;
import com.myProject.kauan_imovel.application.command.venda.CadastrarVendaCommand;
import com.myProject.kauan_imovel.application.query.handler.venda.*;
import com.myProject.kauan_imovel.domain.venda.dto.FaturamentoVendaDTO;
import com.myProject.kauan_imovel.domain.venda.dto.PrejuizoVendaDTO;
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
    private final BuscarFaturamentoDeUmMesQueryHandler buscarFaturamentoDeUmMmsQueryHandler;
    private final BuscarPrejuizosEmVendasQueryHandler buscarPrejuizosEmVendasQueryHandler;

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

    @GetMapping("/listar/faturamento/{mes}")
    public ResponseEntity<FaturamentoVendaDTO> listarFaturamentoMensal(@PathVariable("mes") Integer mes) {return ResponseEntity.ok().body(buscarFaturamentoDeUmMmsQueryHandler.handle(mes));}

    @GetMapping("/listar/prejuizo/venda/{vendaId}")
    public ResponseEntity<PrejuizoVendaDTO> listarSeTevePrejuizoEmUmaVenda(@PathVariable("vendaId") Long id) {return ResponseEntity.ok().body(buscarPrejuizosEmVendasQueryHandler.handle(id));}
}
