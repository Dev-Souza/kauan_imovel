package com.myProject.kauan_imovel.application.command.handlers.pessoa;

import com.myProject.kauan_imovel.application.command.pessoa.CadastrarPessoaVendedoraCommand;
import com.myProject.kauan_imovel.domain.pessoa.PessoaVendedoraEntity;
import com.myProject.kauan_imovel.infrastructure.mapper.VendedorMapper;
import com.myProject.kauan_imovel.infrastructure.repository.pessoa.PessoaVendedoraRepository;
import org.springframework.stereotype.Service;

@Service
public class CadastrarPessoaVendedoraHandler {
    private final PessoaVendedoraRepository repository;
    private final VendedorMapper mapper;

    public CadastrarPessoaVendedoraHandler(PessoaVendedoraRepository repository, VendedorMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public void handle(CadastrarPessoaVendedoraCommand command){
        PessoaVendedoraEntity entity = mapper.toEntity(command);
        repository.save(entity);
    }
}
