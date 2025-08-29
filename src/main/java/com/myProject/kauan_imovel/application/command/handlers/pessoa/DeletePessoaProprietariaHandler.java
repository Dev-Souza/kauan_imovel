package com.myProject.kauan_imovel.application.command.handlers.pessoa;

import com.myProject.kauan_imovel.application.command.pessoa.DeletePessoaProprietariaCommand;
import com.myProject.kauan_imovel.infrastructure.repository.pessoa.PessoaProprietarioRepository;
import org.springframework.stereotype.Service;

@Service
public class DeletePessoaProprietariaHandler {
    private final PessoaProprietarioRepository repository;

    // CONSTRUCTOR
    public DeletePessoaProprietariaHandler(PessoaProprietarioRepository repository) {
        this.repository = repository;
    }

    public void handle(DeletePessoaProprietariaCommand id_pessoaProprietaria_command) {
        if(repository.existsById((id_pessoaProprietaria_command.id_pessoaProprietaria()))){
            repository.deleteById(id_pessoaProprietaria_command.id_pessoaProprietaria());
        }
    }
}
