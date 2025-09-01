package com.myProject.kauan_imovel.application.query.handler.pessoa;

import com.myProject.kauan_imovel.domain.pessoa.PessoaCompradoraEntity;
import com.myProject.kauan_imovel.domain.pessoa.dto.PessoaCompradoraQueryDTO;
import com.myProject.kauan_imovel.infrastructure.mapper.CompradorMapper;
import com.myProject.kauan_imovel.infrastructure.repository.PessoaCompradoraRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BuscarCompradorPorIdHandler {
    private final PessoaCompradoraRepository repository;

    public PessoaCompradoraQueryDTO handle(Long id) {
        if(repository.existsById(id)) {
            PessoaCompradoraEntity entity = repository.findById(id).get();
            PessoaCompradoraQueryDTO dto  = CompradorMapper.toDTO(entity);
            return dto;
        }
        return null;
    }
}
