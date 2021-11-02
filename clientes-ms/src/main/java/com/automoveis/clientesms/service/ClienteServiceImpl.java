package com.automoveis.clientesms.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.automoveis.clientesms.compartilhado.ClienteDto;
import com.automoveis.clientesms.model.Cliente;
import com.automoveis.clientesms.repository.ClienteRepositorio;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ClienteServiceImpl implements ClienteService {
    @Autowired
    private ClienteRepositorio repo;

    @Override
    public ClienteDto criarCliente(ClienteDto cliente) {
        return salvarcliente(cliente);
    }

    @Override
    public List<ClienteDto> obterTodos() {
        List<Cliente> clientes = repo.findAll();

        return clientes.stream()
            .map(cliente -> new ModelMapper().map(cliente, ClienteDto.class))
            .collect(Collectors.toList());
    }

    @Override
    public Optional<ClienteDto> obterPorId(String id) {
        Optional<Cliente> cliente = repo.findById(id);

       if(cliente.isPresent()) {
           return Optional.of(new ModelMapper().map(cliente.get(), ClienteDto.class));
       }

       return Optional.empty();
    }

    @Override
    public void removerCliente(String id) {
        repo.deleteById(id);
    }

    @Override
    public ClienteDto atualizarCliente(String id, ClienteDto cliente) {
        cliente.setId(id);
        return salvarcliente(cliente);
    }

    private ClienteDto salvarcliente(ClienteDto cliente) {
        ModelMapper mapper = new ModelMapper();
        Cliente clienteEntidade = mapper.map(cliente, Cliente.class);
        clienteEntidade = repo.save(clienteEntidade);

        return mapper.map(clienteEntidade, ClienteDto.class);
    }
    
}
