package com.automoveis.service;

import java.util.List;

import com.automoveis.compartilhado.VeiculoDto;

public interface VeiculoService {
    VeiculoDto criarVeiculo(VeiculoDto veiculo);
    List<VeiculoDto> obterTodos();
    java.util.Optional<VeiculoDto> obterPorId(String id);
    void removerVeiculo(String id);
    VeiculoDto atualizarVeiculo(String id, VeiculoDto veiculo);
    
}