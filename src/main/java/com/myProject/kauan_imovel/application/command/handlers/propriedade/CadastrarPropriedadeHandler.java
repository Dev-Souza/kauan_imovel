package com.myProject.kauan_imovel.application.command.handlers.propriedade;

import com.myProject.kauan_imovel.application.command.propriedade.CadastrarPropriedadeCommand;
import com.myProject.kauan_imovel.domain.propriedade.PropriedadeEntity;
import com.myProject.kauan_imovel.infrastructure.mapper.PropriedadeMapper;
import com.myProject.kauan_imovel.infrastructure.repository.EnderecoRepository;
import com.myProject.kauan_imovel.infrastructure.repository.PessoaProprietarioRepository;
import com.myProject.kauan_imovel.infrastructure.repository.PropriedadeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CadastrarPropriedadeHandler {

    private final PropriedadeRepository propriedadeRepository;
    private final PessoaProprietarioRepository pessoaProprietarioRepository;
    private final PropriedadeMapper mapper;

    public void handle(CadastrarPropriedadeCommand command) {
        PropriedadeEntity prop = mapper.toAggregate(command);

        // Seta proprietario por id
        var proprietarioRef = pessoaProprietarioRepository.getReferenceById(command.proprietarioId());
        prop.setProprietario(proprietarioRef);

        // Persistindo
        propriedadeRepository.save(prop);
    }
}
