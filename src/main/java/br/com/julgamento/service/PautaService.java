package br.com.julgamento.service;

import br.com.julgamento.web.rest.dto.PautaDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface PautaService {
    String cadastrar(PautaDTO pautaDTO);

    Page<PautaDTO> obterPautas(Pageable page);
}
