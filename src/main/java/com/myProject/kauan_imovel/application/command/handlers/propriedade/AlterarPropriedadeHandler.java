package com.myProject.kauan_imovel.application.command.handlers.propriedade;

import com.myProject.kauan_imovel.application.command.propriedade.CadastrarPropriedadeCommand;
import com.myProject.kauan_imovel.domain.endereco.EnderecoEntity;
import com.myProject.kauan_imovel.domain.propriedade.PropriedadeEntity;
import com.myProject.kauan_imovel.infrastructure.mapper.PropriedadeMapper;
import com.myProject.kauan_imovel.infrastructure.repository.PessoaProprietarioRepository;
import com.myProject.kauan_imovel.infrastructure.repository.PropriedadeRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AlterarPropriedadeHandler {

    private final PropriedadeRepository propriedadeRepository;
    private final PessoaProprietarioRepository pessoaProprietarioRepository;
    private final PropriedadeMapper mapper;

    @Transactional
    public void handle(Long id, CadastrarPropriedadeCommand cmd) {
        // 1) Carrega a propriedade existente (404 se não existir)
        PropriedadeEntity entidade = propriedadeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Propriedade não encontrada: " + id));

        // 2) Copia campos "simples" (mapper NÃO deve mexer em id/proprietario/endereco)
        mapper.copy(entidade, cmd);

        // 3) Proprietário (obrigatório no PUT) — valida existência
        var proprietario = pessoaProprietarioRepository.findById(cmd.proprietarioId())
                .orElseThrow(() -> new EntityNotFoundException("Proprietário não encontrado: " + cmd.proprietarioId()));
        entidade.setProprietario(proprietario);

        // 4) Endereço (substitui os campos)
        if (entidade.getEndereco() == null) {
            entidade.setEndereco(new EnderecoEntity());
        }
        mapper.copyEndereco(entidade.getEndereco(), cmd.endereco());

        // 5) Salva
        propriedadeRepository.save(entidade);
    }
}