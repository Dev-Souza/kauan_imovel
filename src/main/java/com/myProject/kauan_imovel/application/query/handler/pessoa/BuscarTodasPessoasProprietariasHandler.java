package com.myProject.kauan_imovel.application.query.handler.pessoa;

import com.myProject.kauan_imovel.domain.pessoa.dto.PessoaProprietarioQueryDTO;
import com.myProject.kauan_imovel.infrastructure.mapper.ProprietarioMapper;
import com.myProject.kauan_imovel.infrastructure.repository.PessoaProprietarioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuscarTodasPessoasProprietariasHandler {

    private final PessoaProprietarioRepository repository;

    public BuscarTodasPessoasProprietariasHandler(PessoaProprietarioRepository repository, ProprietarioMapper mapper) {
        this.repository = repository;
    }

    public ResponseEntity<List<PessoaProprietarioQueryDTO>> handle() {
        List<PessoaProprietarioQueryDTO> pessoas = repository.findAll()
                .stream()
                .map(ProprietarioMapper::toQueryDTO)
                .toList();

        return ResponseEntity.ok(pessoas);
    }
}
