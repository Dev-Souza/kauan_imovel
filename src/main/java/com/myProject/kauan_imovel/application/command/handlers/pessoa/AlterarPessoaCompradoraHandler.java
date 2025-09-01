package com.myProject.kauan_imovel.application.command.handlers.pessoa;

import com.myProject.kauan_imovel.application.command.pessoa.CadastrarPessoaCompradoraCommand;
import com.myProject.kauan_imovel.domain.pessoa.PessoaCompradoraEntity;
import com.myProject.kauan_imovel.infrastructure.repository.PessoaCompradoraRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AlterarPessoaCompradoraHandler {

    private final PessoaCompradoraRepository repository;

    public void handle(Long id, CadastrarPessoaCompradoraCommand command) {
        if (repository.existsById(id)) {
            PessoaCompradoraEntity compradora = repository.findById(id).get();
            compradora.setNome(command.nome());
            compradora.setCpf(command.cpf());
            compradora.setEmail(command.email());
            compradora.setTelefone(command.telefone());
            compradora.setFaixaPrecoDesejada(command.faixaPrecoDesejada());
            compradora.setPossuiFinanciamentoAprovado(command.possuiFinanciamentoAprovado());
            compradora.setInstituicaoFinanceira(command.instituicaoFinanceira());
            repository.save(compradora);
        }
    }
}
