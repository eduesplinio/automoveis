package com.automoveis.locacaoms.view.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.automoveis.compartilhado.LocacaoDto;
import com.automoveis.locacaoms.service.LocacaoService;
import com.automoveis.locacaoms.view.model.LocacaoModeloInclusao;
import com.automoveis.locacaoms.view.model.LocacaoModeloResponse;

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
@RequestMapping("/api/locacao")
public class LocacaoController {
    @Autowired
    private LocacaoService service;

    @GetMapping(value="/status")
    public String statusServico(@Value("${local.server.port}") String porta) {
        return String.format("Serviço ativo e executando na porta %s", porta);
    }    

    @PostMapping
    public ResponseEntity<LocacaoModeloResponse> criarLocacao(@RequestBody @Valid LocacaoModeloInclusao Locacao) {
        ModelMapper mapper = new ModelMapper();
        LocacaoDto dto = mapper.map(Locacao, LocacaoDto.class);
        dto = service.criarLocacao(dto);
        return new ResponseEntity<>(mapper.map(dto, LocacaoModeloResponse.class), HttpStatus.CREATED);
    }
    
    @GetMapping
    public ResponseEntity<List<LocacaoModeloResponse>> obterTodos() {
        List<LocacaoDto> dtos = service.obterTodos();

        if(dtos.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        ModelMapper mapper = new ModelMapper();
        List<LocacaoModeloResponse> resp = dtos.stream()
                    .map(dto -> mapper.map(dto, LocacaoModeloResponse.class))
                    .collect(Collectors.toList());

        return new ResponseEntity<>(resp, HttpStatus.OK);
    }
    
    @GetMapping(value="/{id}")
    public ResponseEntity<LocacaoModeloResponse> obterPorId(@PathVariable String id) {
        Optional<LocacaoDto> Locacao = service.obterPorId(id);

        if(Locacao.isPresent()) {
            return new ResponseEntity<>(
                new ModelMapper().map(Locacao.get(), LocacaoModeloResponse.class), 
                HttpStatus.OK
            );
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<Void> removerLocacao(@PathVariable String id) {
        service.removerLocacao(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
