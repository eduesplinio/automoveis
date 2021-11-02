package com.automoveis.locacaoms.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.automoveis.compartilhado.LocacaoDto;
import com.automoveis.locacaoms.model.Locacao;
import com.automoveis.locacaoms.repository.LocacaoRepositorio;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocacaoServiceImpl implements LocacaoService {
    @Autowired
    private LocacaoRepositorio repo;

    @Override
    public LocacaoDto criarLocacao(LocacaoDto Locacao) {
        return salvarLocacao(Locacao);
    }

    @Override
    public List<LocacaoDto> obterTodos() {
        List<Locacao> locacao = repo.findAll();

        return locacao.stream()
            .map(Locacao -> new ModelMapper().map(Locacao, LocacaoDto.class))
            .collect(Collectors.toList());
    }

    @Override
    public Optional<LocacaoDto> obterPorId(String id) {
        Optional<Locacao> Locacao = repo.findById(id);

       if(Locacao.isPresent()) {
           return Optional.of(new ModelMapper().map(Locacao.get(), LocacaoDto.class));
       }

       return Optional.empty();
    }

    @Override
    public void removerLocacao(String id) {
        repo.deleteById(id);
    }

    @Override
    public LocacaoDto atualizarLocacao(String id, LocacaoDto Locacao) {
        Locacao.setId(id);
        return salvarLocacao(Locacao);
    }

    private LocacaoDto salvarLocacao(LocacaoDto Locacao) {
        ModelMapper mapper = new ModelMapper();
        Locacao LocacaoEntidade = mapper.map(Locacao, Locacao.class);
        LocacaoEntidade = repo.save(LocacaoEntidade);

        return mapper.map(LocacaoEntidade, LocacaoDto.class);
    }
    
}