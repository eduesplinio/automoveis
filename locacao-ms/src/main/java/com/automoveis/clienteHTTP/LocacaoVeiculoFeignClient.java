package com.automoveis.clienteHTTP;

import java.util.ArrayList;
import java.util.List;

import com.automoveis.compartilhado.Veiculo;
import com.automoveis.locacaoms.model.Locacao;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name= "veiculo-ms", fallback = LocacaoFeignClientFallback.class)
public interface LocacaoVeiculoFeignClient {
    @GetMapping(path = "/api/veiculos/{locacao}/lista")
    List<Locacao> obter(@PathVariable Veiculo veiculo);
}

@Component
class LocacaoFeignClient implements LocacaoVeiculoFeignClient {

    @Override
    public List<Locacao> obter(Veiculo veiculo) {
        return new ArrayList<>();
    }

}
