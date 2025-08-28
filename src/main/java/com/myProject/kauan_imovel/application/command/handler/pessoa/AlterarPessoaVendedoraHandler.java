package com.myProject.kauan_imovel.application.command.handler.pessoa;

import com.myProject.kauan_imovel.application.command.command.pessoa.CadastrarPessoaVendedoraCommand;
import com.myProject.kauan_imovel.domain.pessoa.PessoaVendedoraEntity;
import com.myProject.kauan_imovel.infrastructure.repository.pessoa.PessoaVendedoraRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class AlterarPessoaVendedoraHandler {

    private final PessoaVendedoraRepository repository;

    public AlterarPessoaVendedoraHandler(PessoaVendedoraRepository repository) {
        this.repository = repository;
    }

    public void handle(Long id, CadastrarPessoaVendedoraCommand command) {
        if (repository.existsById(id)) {
            PessoaVendedoraEntity pessoa = repository.findById(id).get();
            pessoa.setNome(command.nome());
            pessoa.setCpf(command.cpf());
            pessoa.setEmail(command.email());
            pessoa.setTelefone(command.telefone());
            pessoa.setCreci(command.creci());
            pessoa.setDataContratacao(LocalDate.now());
            repository.save(pessoa);
        }
    }
}
