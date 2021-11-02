package com.automoveis.veiculosms.service;

import java.util.List;
import java.util.Optional;

import com.automoveis.veiculosms.compartilhado.VeiculoDto;

public interface VeiculoService {
    VeiculoDto criarVeiculo(VeiculoDto Veiculo);
    List<VeiculoDto> obterTodos();
    Optional<VeiculoDto> obterPorId(String id);
    void removerVeiculo(String id);
    VeiculoDto atualizarVeiculo(String id, VeiculoDto Veiculo);
    
}