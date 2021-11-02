package com.automoveis.veiculosms.repository;

import com.automoveis.veiculosms.model.Veiculo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeiculoRepositorio extends MongoRepository<Veiculo, String> {

}