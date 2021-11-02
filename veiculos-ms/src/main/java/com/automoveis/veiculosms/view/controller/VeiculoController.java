package com.automoveis.veiculosms.view.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.automoveis.veiculosms.compartilhado.VeiculoDto;
import com.automoveis.veiculosms.service.VeiculoService;
import com.automoveis.veiculosms.view.model.VeiculoModeloInclusao;
import com.automoveis.veiculosms.view.model.VeiculoModeloResponse;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/veiculos")
public class VeiculoController {
    @Autowired
    private VeiculoService service;

    @GetMapping(value="/status")
    public String statusServico(@Value("${local.server.port}") String porta) {
        return String.format("Serviço ativo e executando na porta %s", porta);
    }    

    @PostMapping
    public ResponseEntity<VeiculoModeloResponse> criarVeiculos(@RequestBody @Valid VeiculoModeloInclusao Veiculos) {
        ModelMapper mapper = new ModelMapper();
        VeiculoDto dto = mapper.map(Veiculos, VeiculoDto.class);
        dto = service.criarVeiculo(dto);
        return new ResponseEntity<>(mapper.map(dto, VeiculoModeloResponse.class), HttpStatus.CREATED);
    }
    
    @GetMapping
    public ResponseEntity<List<VeiculoModeloResponse>> obterTodos() {
        List<VeiculoDto> dtos = service.obterTodos();

        if(dtos.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        ModelMapper mapper = new ModelMapper();
        List<VeiculoModeloResponse> resp = dtos.stream()
                    .map(dto -> mapper.map(dto, VeiculoModeloResponse.class))
                    .collect(Collectors.toList());

        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<Void> removerVeiculos(@PathVariable String id) {
        service.removerVeiculo(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
