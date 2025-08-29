package com.myProject.kauan_imovel.application.command.handlers.pessoa;

import com.myProject.kauan_imovel.infrastructure.repository.PessoaVendedoraRepository;
import org.springframework.stereotype.Service;

@Service
public class DeletePessoaVendedoraHandler {
    private final PessoaVendedoraRepository repository;

    public DeletePessoaVendedoraHandler(PessoaVendedoraRepository repository) {
        this.repository = repository;
    }

    public void handle(Long id) {
        if(repository.existsById(id)) {
            repository.deleteById(id);
        }
    }
}
