package br.com.julgamento.web.rest;

import br.com.julgamento.client.UsuarioClient;
import br.com.julgamento.service.UsuarioSevice;
import br.com.julgamento.web.rest.dto.ResponseClientDTO;
import br.com.julgamento.web.rest.dto.UsuarioDTO;
import lombok.AllArgsConstructor;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@AllArgsConstructor
@RestController
@SuppressWarnings({"java:S4834", "squid:S4834"})
@RequestMapping("usuario")
public class UsuarioResource {

    private UsuarioSevice usuarioSevice;

    private UsuarioClient usuarioClient;

    @PostMapping
    public ResponseEntity<String> criarUsuario(@RequestBody @Valid UsuarioDTO usuarioDTO) {
        return usuarioSevice.cadastrar(usuarioDTO);
    }

    @GetMapping(value = "valida-cpf/{cpf}")
    public EntityModel<ResponseClientDTO> validaCPF(@PathVariable String cpf) {
        return usuarioClient.validarCPF(cpf);
    }
}
