package com.myProject.kauan_imovel.application.query.handler.pessoa;

import com.myProject.kauan_imovel.domain.pessoa.dto.PessoaVendedoraQueryDTO;
import com.myProject.kauan_imovel.infrastructure.mapper.VendedorMapper;
import com.myProject.kauan_imovel.infrastructure.repository.PessoaVendedoraRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuscarTodosVendedoresHandler {

    private final PessoaVendedoraRepository repository;

    public BuscarTodosVendedoresHandler(PessoaVendedoraRepository repository) {
        this.repository = repository;
    }

    public ResponseEntity<List<PessoaVendedoraQueryDTO>> handle() {
        List<PessoaVendedoraQueryDTO> pessoas = repository.findAll()
                .stream()
                .map(VendedorMapper::toQueryDTO)
                .toList();

        return ResponseEntity.ok().body(pessoas);
    }
}
