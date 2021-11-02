package com.automoveis.repository;

import com.automoveis.model.Veiculo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeiculoRepositorio extends MongoRepository<Veiculo, String> {

}
