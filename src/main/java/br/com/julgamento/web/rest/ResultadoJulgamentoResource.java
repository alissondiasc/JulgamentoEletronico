package br.com.julgamento.web.rest;

import br.com.julgamento.service.ResultadoJulgamentoService;
import br.com.julgamento.web.rest.dto.ResultadoJulgamentoDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@SuppressWarnings({"java:S4834", "squid:S4834"})
@RequestMapping("resultado-julgamento")
public class ResultadoJulgamentoResource {

    private ResultadoJulgamentoService resultadoJulgamentoService;

    @GetMapping(value = "encerrar-sessao/{idSessaoJulgamento}")
    public ResponseEntity<ResultadoJulgamentoDTO> cadastrarSessaoJulgamento(@PathVariable String idSessaoJulgamento) throws Exception {
        return resultadoJulgamentoService.resultadoJulgamentoEletronico(idSessaoJulgamento);
    }
}
