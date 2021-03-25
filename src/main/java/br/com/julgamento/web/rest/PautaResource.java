package br.com.julgamento.web.rest;

import br.com.julgamento.service.PautaService;
import br.com.julgamento.web.rest.dto.PautaDTO;
import br.com.julgamento.web.rest.dto.UsuarioDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@AllArgsConstructor
@RestController
@SuppressWarnings({"java:S4834", "squid:S4834"})
@RequestMapping("pauta")
public class PautaResource {

    private PautaService pautaService;

    @PostMapping
    public ResponseEntity<String> criarPauta(@RequestBody @Valid PautaDTO pautaDTO) {
        return pautaService.cadastrar(pautaDTO);
    }
}
