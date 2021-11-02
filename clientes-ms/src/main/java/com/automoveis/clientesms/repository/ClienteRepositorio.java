package com.automoveis.clientesms.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.automoveis.clientesms.model.Cliente;

@Repository
public interface ClienteRepositorio extends MongoRepository<Cliente, String> {

}
