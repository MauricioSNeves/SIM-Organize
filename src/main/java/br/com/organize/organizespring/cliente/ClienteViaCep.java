package br.com.organize.organizespring.cliente;

import br.com.organize.organizespring.model.Cep;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "viacep", url = "https://viacep.com.br")
public interface ClienteViaCep {

    @GetMapping("/ws/{cep}/json")
    Cep getCep(@PathVariable String cep);

}
