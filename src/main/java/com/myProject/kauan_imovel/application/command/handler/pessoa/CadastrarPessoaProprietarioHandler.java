package com.myProject.kauan_imovel.application.command.handler.pessoa;

import com.myProject.kauan_imovel.application.command.command.pessoa.CadastrarPessoaProprietarioCommand;
import com.myProject.kauan_imovel.domain.pessoa.PessoaProprietarioEntity;
import com.myProject.kauan_imovel.infrastructure.mapper.ProprietarioMapper;
import com.myProject.kauan_imovel.infrastructure.repository.pessoa.PessoaProprietarioRepository;
import org.springframework.stereotype.Service;

@Service
public class CadastrarPessoaProprietarioHandler {
    private final PessoaProprietarioRepository repository;

    public CadastrarPessoaProprietarioHandler(PessoaProprietarioRepository repository) {
        this.repository = repository;
    }

    public void handle(CadastrarPessoaProprietarioCommand command) {
        PessoaProprietarioEntity proprietario = ProprietarioMapper.toEntity(command);
        repository.save(proprietario);
    }
}
