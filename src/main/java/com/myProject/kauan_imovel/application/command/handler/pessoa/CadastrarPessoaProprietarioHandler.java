package com.myProject.kauan_imovel.application.command.handler.pessoa;

import com.myProject.kauan_imovel.application.command.command.pessoa.CadastrarPessoaProprietarioCommand;
import com.myProject.kauan_imovel.domain.pessoa.PessoaProprietarioEntity;
import com.myProject.kauan_imovel.infrastructure.mapper.ProprietarioMapper;
import com.myProject.kauan_imovel.infrastructure.repository.pessoa.PessoaProprietarioRepository;
import org.springframework.stereotype.Service;

@Service
public class CadastrarPessoaProprietarioHandler {
    private final PessoaProprietarioRepository repository;
    private final ProprietarioMapper proprietarioMapper;

    public CadastrarPessoaProprietarioHandler(PessoaProprietarioRepository repository, ProprietarioMapper mapper, ProprietarioMapper proprietarioMapper) {
        this.repository = repository;
        this.proprietarioMapper = proprietarioMapper;
    }

    public void handle(CadastrarPessoaProprietarioCommand command) {
        PessoaProprietarioEntity proprietario = proprietarioMapper.toEntity(command);
        repository.save(proprietario);
    }
}
