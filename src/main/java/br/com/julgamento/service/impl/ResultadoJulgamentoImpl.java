package br.com.julgamento.service.impl;

import br.com.julgamento.domain.ResultadoJulgamento;
import br.com.julgamento.domain.SessaoJulgamento;
import br.com.julgamento.domain.enums.Indicador;
import br.com.julgamento.domain.enums.ResultadoVotacao;
import br.com.julgamento.repository.ResultadoJulgamentoRepository;
import br.com.julgamento.repository.SessaoJulgamentoRepository;
import br.com.julgamento.service.ResultadoJulgamentoService;
import br.com.julgamento.service.VotoParticipacaoService;
import br.com.julgamento.service.mapper.ResultadoJulgamentoMapper;
import br.com.julgamento.web.rest.dto.ResultadoJulgamentoDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import static java.util.Objects.nonNull;

@AllArgsConstructor
@Service
@Slf4j
public class ResultadoJulgamentoImpl implements ResultadoJulgamentoService {

    private ResultadoJulgamentoRepository resultadoJulgamentoRepository;
    private SessaoJulgamentoRepository sessaoJulgamentoRepository;
    private VotoParticipacaoService votoParticipacaoService;
    private ResultadoJulgamentoMapper resultadoJulgamentoMapper;

    @Override
    public ResultadoJulgamentoDTO cadastra(String idJulgamentoSessao) {
        ResultadoVotacao resultadoVotacao = votoParticipacaoService.apurarVotosSessaoJulgamento(idJulgamentoSessao);
        ResultadoJulgamento  resultadoJulgamento = ResultadoJulgamento.builder().sessaoJulgamento(SessaoJulgamento.builder().id(idJulgamentoSessao).build()).build();
        resultadoJulgamento.setResultadoVotacao(resultadoVotacao);
        resultadoJulgamentoRepository.save(resultadoJulgamento);
        return resultadoJulgamentoMapper.entidadeParaDTO(resultadoJulgamento);
    }
    @Override
    public ResponseEntity<ResultadoJulgamentoDTO> resultadoJulgamentoEletronico(String idSessaoJulgamento) throws Exception {
        ResultadoJulgamento resultadoJulgamento = resultadoJulgamentoRepository.findBySessaoJulgamento(SessaoJulgamento.builder().id(idSessaoJulgamento).build());
        if(nonNull(resultadoJulgamento)){
            return ResponseEntity.ok(resultadoJulgamentoMapper.entidadeParaDTO(resultadoJulgamento));
        }
        SessaoJulgamento sessaoJulgamento = sessaoJulgamentoRepository.findById(idSessaoJulgamento) .orElseThrow(() -> new Exception("Não existe sessão julgamento com esse id"));
        ResultadoJulgamentoDTO resultadoJulgamentoDTO =  cadastra(idSessaoJulgamento);
        sessaoJulgamento.setIndSessaoAberta(Indicador.N);
        sessaoJulgamentoRepository.save(sessaoJulgamento);
        return ResponseEntity.ok(resultadoJulgamentoDTO);
        }



}
