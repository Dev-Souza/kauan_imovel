package com.myProject.kauan_imovel.application.command.handlers.pessoa;

import com.myProject.kauan_imovel.infrastructure.repository.PessoaCompradoraRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeletePessoaCompradoraHandler {
    private final PessoaCompradoraRepository repository;

    public void handle(Long id){
        if(repository.existsById(id)){
            repository.deleteById(id);
        }
    }
}
