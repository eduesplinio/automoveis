package com.automoveis.locacaoms.repository;

import com.automoveis.locacaoms.model.Locacao;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocacaoRepositorio extends MongoRepository<Locacao, String> {

}