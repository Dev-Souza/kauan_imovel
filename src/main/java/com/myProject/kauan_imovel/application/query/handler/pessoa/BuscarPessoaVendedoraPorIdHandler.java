package com.myProject.kauan_imovel.application.query.handler.pessoa;

import com.myProject.kauan_imovel.domain.pessoa.PessoaVendedoraEntity;
import com.myProject.kauan_imovel.domain.pessoa.dto.PessoaVendedoraQueryDTO;
import com.myProject.kauan_imovel.infrastructure.mapper.VendedorMapper;
import com.myProject.kauan_imovel.infrastructure.repository.PessoaVendedoraRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BuscarPessoaVendedoraPorIdHandler {
    public final PessoaVendedoraRepository repository;

    public BuscarPessoaVendedoraPorIdHandler(PessoaVendedoraRepository repository) {
        this.repository = repository;
    }

    public PessoaVendedoraQueryDTO handle(Long id) {
        if(repository.existsById(id)){
            Optional<PessoaVendedoraEntity> pessoa = repository.findById(id);
            PessoaVendedoraQueryDTO dto = VendedorMapper.toQueryDTO(pessoa.get());
            return dto;
        }
        return null;
    }
}
