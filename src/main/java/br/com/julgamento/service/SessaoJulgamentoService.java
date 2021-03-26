package br.com.julgamento.service;

import br.com.julgamento.domain.ResultadoJulgamento;
import br.com.julgamento.domain.SessaoJulgamento;
import br.com.julgamento.domain.enums.Indicador;
import br.com.julgamento.web.rest.dto.ResultadoJulgamentoDTO;
import br.com.julgamento.web.rest.dto.SessaoJulgamentoDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface SessaoJulgamentoService {

   String cadastrar(SessaoJulgamentoDTO sessaoJulgamentoDTO);

    SessaoJulgamento obterSessaoJulgamentoPorId(String idSessaoJulgamento) throws Exception;

    void atualizarIndicador(SessaoJulgamento sessaoJulgamento, Indicador n);

    Page<SessaoJulgamentoDTO> obterSessoesJulgamentos(Pageable pageable);
}
