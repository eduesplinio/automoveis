package com.automoveis.clientesms.service;

import java.util.List;
import java.util.Optional;

import com.automoveis.clientesms.compartilhado.ClienteDto;

public interface ClienteService {
    ClienteDto criarCliente(ClienteDto cliente);
    List<ClienteDto> obterTodos();
    Optional<ClienteDto> obterPorId(String id);
    void removerCliente(String id);
    ClienteDto atualizarCliente(String id, ClienteDto cliente);
    
}