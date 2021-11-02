package com.automoveis.locacaoms.service;

import java.util.List;

import com.automoveis.compartilhado.LocacaoDto;

public interface LocacaoService {
    LocacaoDto criarLocacao(LocacaoDto locacao);
    List<LocacaoDto> obterTodos();
    java.util.Optional<LocacaoDto> obterPorId(String id);
    void removerLocacao(String id);
    LocacaoDto atualizarLocacao(String id, LocacaoDto locacao);
    
}
