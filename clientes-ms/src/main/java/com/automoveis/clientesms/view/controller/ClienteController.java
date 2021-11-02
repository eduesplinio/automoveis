package com.automoveis.clientesms.view.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.automoveis.clientesms.compartilhado.ClienteDto;
import com.automoveis.clientesms.model.Cliente;
import com.automoveis.clientesms.repository.ClienteRepositorio;
import com.automoveis.clientesms.service.ClienteService;
import com.automoveis.clientesms.view.model.ClienteModeloRequest;
import com.automoveis.clientesms.view.model.ClienteModeloResponse;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/clientes")
public class ClienteController {


    @Autowired
    private ClienteService service;

    @GetMapping(value="/status")
    public String statusServico(@Value("${local.server.port}") String porta) {
        return String.format("Serviço ativo e executando na porta %s", porta);
    }
    

    @PostMapping
    public ResponseEntity<ClienteModeloResponse> criarCliente(@RequestBody @Valid ClienteModeloRequest Cliente) {
        ModelMapper mapper = new ModelMapper();
        ClienteDto dto = mapper.map(Cliente, ClienteDto.class);
        dto = service.criarCliente(dto);
        return new ResponseEntity<>(mapper.map(dto, ClienteModeloResponse.class), HttpStatus.CREATED);
    }
    
    @PutMapping(value="/{id}")
    public ResponseEntity<ClienteModeloResponse> atualizarCliente(@PathVariable String id,
        @Valid @RequestBody Cliente Cliente) {
        ModelMapper mapper = new ModelMapper();
        ClienteDto dto = mapper.map(Cliente, ClienteDto.class);
        dto = service.atualizarCliente(id, dto);

        return new ResponseEntity<>(mapper.map(dto, ClienteModeloResponse.class), HttpStatus.OK);
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<Void> removerCliente(@PathVariable String id) {
        service.removerCliente(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } 
}
