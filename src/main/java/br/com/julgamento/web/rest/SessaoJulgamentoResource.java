package br.com.julgamento.web.rest;

import br.com.julgamento.domain.ResultadoJulgamento;
import br.com.julgamento.service.ResultadoJulgamentoService;
import br.com.julgamento.service.SessaoJulgamentoService;
import br.com.julgamento.web.rest.dto.ResultadoJulgamentoDTO;
import br.com.julgamento.web.rest.dto.SessaoJulgamentoDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@AllArgsConstructor
@RestController
@SuppressWarnings({"java:S4834", "squid:S4834"})
@RequestMapping("sessao-julgamento")
public class SessaoJulgamentoResource {

    private SessaoJulgamentoService sessaoJulgamentoService;

    @PostMapping
    public ResponseEntity<String> cadastrarSessaoJulgamento(@RequestBody @Valid SessaoJulgamentoDTO sessaoJulgamentoDTO) {
        return sessaoJulgamentoService.cadastrar(sessaoJulgamentoDTO);
    }


}
