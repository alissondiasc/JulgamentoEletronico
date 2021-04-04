package br.com.julgamento.client;

import br.com.julgamento.web.rest.dto.ResponseClientDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "valida-cpf", url = "${usuario.client.url}")
public interface UsuarioClient {

    @GetMapping(value = "/{cpf}")
    ResponseClientDTO  validarCPF(@PathVariable  String cpf);
}
