package br.com.julgamento.service.impl;

import br.com.julgamento.domain.ResultadoJulgamento;
import br.com.julgamento.domain.SessaoJulgamento;
import br.com.julgamento.domain.enums.Indicador;
import br.com.julgamento.repository.SessaoJulgamentoRepository;
import br.com.julgamento.service.ResultadoJulgamentoService;
import br.com.julgamento.service.SessaoJulgamentoService;
import br.com.julgamento.service.mapper.SessaoJulgamentoMapper;
import br.com.julgamento.web.rest.dto.ResultadoJulgamentoDTO;
import br.com.julgamento.web.rest.dto.SessaoJulgamentoDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
@Slf4j
public class SessaoJulgamentoServiceImpl implements SessaoJulgamentoService {

    private SessaoJulgamentoRepository sessaoJulgamentoRepository;
    private SessaoJulgamentoMapper sessaoJulgamentoMapper;

    @Override
    public ResponseEntity<String> cadastrar(SessaoJulgamentoDTO sessaoJulgamentoDTO) {
        SessaoJulgamento sessaoJulgamento = sessaoJulgamentoMapper.dtoParaEntidade(sessaoJulgamentoDTO);
        atualizarIndicador(sessaoJulgamento, Indicador.S);
        return ResponseEntity.ok("Operação realizada com sucesso.");
    }

    @Override
    public SessaoJulgamento obterSessaoJulgamentoPorId(String idSessaoJulgamento) throws Exception {
        return sessaoJulgamentoRepository.findById(idSessaoJulgamento) .orElseThrow(() -> new Exception("Não existe sessão julgamento com esse id"));
    }


    @Override
    public void atualizarIndicador(SessaoJulgamento sessaoJulgamento, Indicador n) {
        sessaoJulgamento.setIndSessaoAberta(n);
        sessaoJulgamentoRepository.save(sessaoJulgamento);
    }
}
