package com.myProject.kauan_imovel.application.command.handlers.pessoa;

import com.myProject.kauan_imovel.application.command.pessoa.CadastrarPessoaCompradoraCommand;
import com.myProject.kauan_imovel.domain.pessoa.PessoaCompradoraEntity;
import com.myProject.kauan_imovel.infrastructure.mapper.CompradorMapper;
import com.myProject.kauan_imovel.infrastructure.repository.PessoaCompradoraRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CadastrarPessoaCompradoraHandler {
    private final PessoaCompradoraRepository pessoaCompradoraRepository;
    private final CompradorMapper mapper;

    public void handle(CadastrarPessoaCompradoraCommand command) {
        PessoaCompradoraEntity compradora = mapper.toEntity(command);
        pessoaCompradoraRepository.save(compradora);
    }
}
