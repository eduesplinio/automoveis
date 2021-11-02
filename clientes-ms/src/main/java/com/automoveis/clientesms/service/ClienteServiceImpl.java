package com.automoveis.clientesms.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.automoveis.clientesms.clienteHTTP.LocacaoFeignClient;
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

    @Autowired
    private LocacaoFeignClient LocacaoMsClient;

    @Override
    public ClienteDto criarCliente(ClienteDto Cliente) {
        return salvarCliente(Cliente);
    }

    @Override
    public List<ClienteDto> obterTodos() {
        List<Cliente> Clientes = repo.findAll();

        return Clientes.stream()
            .map(Cliente -> new ModelMapper().map(Cliente, ClienteDto.class))
            .collect(Collectors.toList());
    }

    @Override
    public Optional<ClienteDto> obterPorId(String id) {
       Optional<Cliente> Cliente = repo.findById(id);

        
       if(Cliente.isPresent()) {
           ClienteDto dto = new ModelMapper().map(Cliente.get(), ClienteDto.class);
           dto.setLocacao(LocacaoMsClient.obter(id));
           return Optional.of(dto);
       }

       return Optional.empty();
    }

    @Override
    public void removerCliente(String id) {
        repo.deleteById(id);
    }

    @Override
    public ClienteDto atualizarCliente(String id, ClienteDto Cliente) {
        Cliente.setId(id);
        return salvarCliente(Cliente);
    }

    private ClienteDto salvarCliente(ClienteDto Cliente) {
        ModelMapper mapper = new ModelMapper();
        Cliente ClienteEntidade = mapper.map(Cliente, Cliente.class);
        ClienteEntidade = repo.save(ClienteEntidade);

        return mapper.map(ClienteEntidade, ClienteDto.class);
    }


}
