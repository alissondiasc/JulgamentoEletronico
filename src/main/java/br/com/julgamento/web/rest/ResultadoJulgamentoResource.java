package br.com.julgamento.web.rest;

import br.com.julgamento.service.ResultadoJulgamentoService;
import br.com.julgamento.web.rest.dto.DetalhesResultadoJulgamentoDTO;
import br.com.julgamento.web.rest.dto.ResultadoJulgamentoDTO;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@SuppressWarnings({"java:S4834", "squid:S4834"})
@RequestMapping("resultado-julgamento")
public class ResultadoJulgamentoResource {

    private ResultadoJulgamentoService resultadoJulgamentoService;

    @ApiOperation(value = "Encerrar e retornar sessão de julgamento")
    @GetMapping(value = "encerrar-sessao/{idSessaoJulgamento}")
    public ResponseEntity<ResultadoJulgamentoDTO> encerrarCadastrarResultadoJulgamento(@PathVariable String idSessaoJulgamento) throws Exception {
        return ResponseEntity.ok(resultadoJulgamentoService.encerrarAndCadastrarResultadoJulg(idSessaoJulgamento));
    }

    @ApiOperation(value = "Encerrar e retornar sessão de julgamento")
    @GetMapping(value = "obter-detalhes-resultado/{idSessaoJulgamento}")
    public ResponseEntity<DetalhesResultadoJulgamentoDTO> obterDetalhesResultado(@PathVariable String idSessaoJulgamento) throws Exception {
        return ResponseEntity.ok(resultadoJulgamentoService.obterDetalhesResultadoJulgamento(idSessaoJulgamento));
    }

    @ApiOperation(value = "Obter votos efetuados")
    @GetMapping
    public ResponseEntity<Page<ResultadoJulgamentoDTO>> obterResultadoJulgamento(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "conut", defaultValue = "10") Integer count,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction,
            @RequestParam(value = "orderBy", defaultValue = "voto") String orderBy
    ) {
        Pageable pageable = PageRequest.of(page, count, Sort.Direction.valueOf(direction), orderBy);
        return ResponseEntity.ok(resultadoJulgamentoService.obterResultadosJulgamento(pageable));
    }
}
