package br.com.julgamento.service.mapper;

import br.com.julgamento.domain.ResultadoJulgamento;
import br.com.julgamento.domain.SessaoJulgamento;
import static  br.com.julgamento.domain.enums.ResultadoVotacao.getValue;
import br.com.julgamento.web.rest.dto.ResultadoJulgamentoDTO;
import br.com.julgamento.web.rest.dto.SessaoJulgamentoDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class ResultadoJulgamentoMapper  implements AbstractMapper<ResultadoJulgamento, ResultadoJulgamentoDTO> {

    @Override
    public ResultadoJulgamentoDTO entidadeParaDTO(ResultadoJulgamento entidade) {
        return ResultadoJulgamentoDTO.builder()
                .id(entidade.getId())
                .idJulgamento(entidade.getSessaoJulgamento().getId())
                .resultadoVotacao(entidade.getResultadoVotacao().getValor())
                .build();
    }

    @Override
    public ResultadoJulgamento dtoParaEntidade(ResultadoJulgamentoDTO resultadoJulgamentoDTO) {
        return ResultadoJulgamento.builder()
                .sessaoJulgamento(SessaoJulgamento.builder().id(resultadoJulgamentoDTO.getResultadoVotacao()).build())
                .resultadoVotacao(getValue(resultadoJulgamentoDTO.getResultadoVotacao()))
                .build();
    }
}
