package com.automoveis.clienteHTTP;

import java.util.ArrayList;
import java.util.List;

import com.automoveis.locacaoms.model.Locacao;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name= "clientes-ms", fallback = LocacaoFeignClientFallback.class)
public interface LocacaoClienteFeignClient {
    @GetMapping(path = "/api/clientes/{locacao}/lista")
    List<Locacao> obterCliente(@PathVariable String cliente);
}

@Component
class LocacaoFeignClientFallback implements LocacaoClienteFeignClient {

    @Override
    public List<Locacao> obterCliente(String cliente) {
        return new ArrayList<>();
    }

}
