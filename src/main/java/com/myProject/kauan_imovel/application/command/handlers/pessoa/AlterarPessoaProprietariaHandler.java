package com.myProject.kauan_imovel.application.command.handlers.pessoa;

import com.myProject.kauan_imovel.application.command.pessoa.CadastrarPessoaProprietarioCommand;
import com.myProject.kauan_imovel.domain.pessoa.PessoaProprietarioEntity;
import com.myProject.kauan_imovel.infrastructure.repository.PessoaProprietarioRepository;
import org.springframework.stereotype.Service;

@Service
public class AlterarPessoaProprietariaHandler {

    private final PessoaProprietarioRepository repository;

    public AlterarPessoaProprietariaHandler(PessoaProprietarioRepository repository) {
        this.repository = repository;
    }

    public void handle(Long id, CadastrarPessoaProprietarioCommand command) {
        if(repository.existsById(id)){
            PessoaProprietarioEntity entity = repository.findById(id).get();
            entity.setNome(command.nome());
            entity.setCpf(command.cpf());
            entity.setEmail(command.email());
            entity.setTelefone(command.telefone());
            entity.setDataCadastro(command.dataCadastro());
            entity.setObservacoes(command.observacoes());
            repository.save(entity);
        }
    }
}
