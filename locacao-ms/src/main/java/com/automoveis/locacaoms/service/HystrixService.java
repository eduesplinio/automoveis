package com.automoveis.locacaoms.service;

import com.automoveis.compartilhado.LocacaoDto;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "produto-ms", fallback = VeiculoDisponivel.class)
public interface HystrixService {
  @PostMapping(value = "/api/produtos/{id}/acertoestoque", consumes = "application/json")
  LocacaoDto alterarEstoque(@RequestBody VeiculoDisponivel acerto, @PathVariable int id);
}

@Component
class VeiculoDisponivel implements HystrixService {

  @Override
  public LocacaoDto alterarEstoque(VeiculoDisponivel acerto, int id) {
    return null;
  }

}