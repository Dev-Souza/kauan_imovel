package com.myProject.kauan_imovel.application.command.handler.pessoa;

import com.myProject.kauan_imovel.application.command.command.pessoa.CadastrarPessoaProprietarioCommand;
import com.myProject.kauan_imovel.domain.pessoa.PessoaProprietarioEntity;
import com.myProject.kauan_imovel.infrastructure.mapper.ProprietarioMapper;
import com.myProject.kauan_imovel.infrastructure.repository.pessoa.PessoaProprietarioRepository;
import org.springframework.stereotype.Service;

@Service
public class CadastrarPessoaProprietarioHandler {
    private final PessoaProprietarioRepository repository;
    private final ProprietarioMapper mapper;

    public CadastrarPessoaProprietarioHandler(PessoaProprietarioRepository repository, ProprietarioMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public void handle(CadastrarPessoaProprietarioCommand command) {
        PessoaProprietarioEntity proprietario = mapper.toEntity(command);
        repository.save(proprietario);
    }
}
