package br.com.julgamento.service;

import br.com.julgamento.web.rest.dto.ResultadoJulgamentoDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface ResultadoJulgamentoService {

    ResultadoJulgamentoDTO cadastra(String idJulgamentoSessao);

    ResponseEntity<ResultadoJulgamentoDTO> resultadoJulgamentoEletronico(String idSessaoJulgamento) throws Exception;
}
