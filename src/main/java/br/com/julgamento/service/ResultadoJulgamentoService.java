package br.com.julgamento.service;

import br.com.julgamento.web.rest.dto.DetalhesResultadoJulgamentoDTO;
import br.com.julgamento.web.rest.dto.ResultadoJulgamentoDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface ResultadoJulgamentoService {

    ResultadoJulgamentoDTO cadastra(String idJulgamentoSessao);

    ResultadoJulgamentoDTO encerrarAndCadastrarResultadoJulg(String idSessaoJulgamento) throws Exception;

    DetalhesResultadoJulgamentoDTO obterDetalhesResultadoJulgamento(String idResultado) throws Exception;

    Page<ResultadoJulgamentoDTO> obterResultadosJulgamento(Pageable pageable);
}
