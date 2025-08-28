package com.myProject.kauan_imovel.application.query.handler.pessoa;

import com.myProject.kauan_imovel.domain.pessoa.PessoaProprietarioEntity;
import com.myProject.kauan_imovel.domain.pessoa.dto.PessoaProprietarioQueryDTO;
import com.myProject.kauan_imovel.infrastructure.mapper.ProprietarioMapper;
import com.myProject.kauan_imovel.infrastructure.repository.pessoa.PessoaProprietarioRepository;
import org.springframework.stereotype.Service;

@Service
public class BuscarPessoaProprietariaPorId {
    private final PessoaProprietarioRepository repository;

    public BuscarPessoaProprietariaPorId(PessoaProprietarioRepository repository, ProprietarioMapper mapper) {
        this.repository = repository;
    }

    public PessoaProprietarioQueryDTO handle(Long id) {
        if(repository.existsById(id)) {
            PessoaProprietarioEntity entity = repository.findById(id).get();
            PessoaProprietarioQueryDTO dto = ProprietarioMapper.toQueryDTO(entity);
            return dto;
        }
        return null;
    }
}
