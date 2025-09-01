package com.myProject.kauan_imovel.application.query.handler.pessoa;

import com.myProject.kauan_imovel.domain.pessoa.dto.PessoaCompradoraQueryDTO;
import com.myProject.kauan_imovel.infrastructure.mapper.CompradorMapper;
import com.myProject.kauan_imovel.infrastructure.repository.PessoaCompradoraRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class BuscarTodosCompradoresHandler {
    private final PessoaCompradoraRepository repository;
    private final CompradorMapper mapper;

    public List<PessoaCompradoraQueryDTO> handle(){
        List<PessoaCompradoraQueryDTO> compradores = repository.findAll()
                .stream()
                .map(CompradorMapper::toDTO)
                .toList();
        return compradores;
    }
}
