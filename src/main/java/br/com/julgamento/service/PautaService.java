package br.com.julgamento.service;

import br.com.julgamento.web.rest.dto.PautaDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface PautaService {
    ResponseEntity<String> cadastrar(PautaDTO pautaDTO);
}
