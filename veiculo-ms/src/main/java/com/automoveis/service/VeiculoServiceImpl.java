package com.automoveis.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.automoveis.compartilhado.VeiculoDto;
import com.automoveis.model.Veiculo;
import com.automoveis.repository.VeiculoRepositorio;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VeiculoServiceImpl implements VeiculoService {
    @Autowired
    private VeiculoRepositorio repo;

    @Override
    public VeiculoDto criarVeiculo(VeiculoDto Veiculo) {
        return salvarVeiculo(Veiculo);
    }

    @Override
    public List<VeiculoDto> obterTodos() {
        List<Veiculo> Veiculo = repo.findAll();

        return Veiculo.stream()
            .map(veiculo -> new ModelMapper().map(Veiculo, VeiculoDto.class))
            .collect(Collectors.toList());
    }

    @Override
    public Optional<VeiculoDto> obterPorId(String id) {
        Optional<Veiculo> Veiculo = repo.findById(id);

       if(Veiculo.isPresent()) {
           return Optional.of(new ModelMapper().map(Veiculo.get(), VeiculoDto.class));
       }

       return Optional.empty();
    }

    @Override
    public void removerVeiculo(String id) {
        repo.deleteById(id);
    }

    @Override
    public VeiculoDto atualizarVeiculo(String id, VeiculoDto Veiculo) {
        Veiculo.setId(id);
        return salvarVeiculo(Veiculo);
    }

    private VeiculoDto salvarVeiculo(VeiculoDto Veiculo) {
        ModelMapper mapper = new ModelMapper();
        Veiculo VeiculoEntidade = mapper.map(Veiculo, Veiculo.class);
        VeiculoEntidade = repo.save(VeiculoEntidade);

        return mapper.map(VeiculoEntidade, VeiculoDto.class);
    }
    
}
