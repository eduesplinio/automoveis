package com.automoveis.clientesms.clienteHTTP;

import java.util.ArrayList;
import java.util.List;

import com.automoveis.clientesms.compartilhado.Locacao;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name= "locacao-ms", fallback = LocacaoFeignClientFallback.class)
public interface LocacaoFeignClient {
    @GetMapping(path = "/api/locacao/lista")
    List<Locacao> obter(@PathVariable String cliente);
}

@Component
class LocacaoFeignClientFallback implements LocacaoFeignClient {

    @Override
    public List<Locacao> obter(String cliente) {
        return new ArrayList<>();
    }

}
