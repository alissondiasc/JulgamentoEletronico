package br.com.julgamento.service.mapper;

import br.com.julgamento.domain.Pauta;
import br.com.julgamento.domain.SessaoJulgamento;
import br.com.julgamento.web.rest.dto.SessaoJulgamentoDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

import static br.com.julgamento.util.DateUtil.addOneMinutoToDate;
import static br.com.julgamento.util.DateUtil.getZeroTimeDate;
import static java.util.Objects.isNull;

@AllArgsConstructor
@Component
public class SessaoJulgamentoMapper implements AbstractMapper<SessaoJulgamento, SessaoJulgamentoDTO> {

    @Override
    public SessaoJulgamentoDTO entidadeParaDTO(SessaoJulgamento entidade) {
        return SessaoJulgamentoDTO.builder()
                .id(entidade.getId())
                .idPauta(entidade.getPauta().getId())
                .dataInicio(entidade.getDataInicio())
                .dataFim(entidade.getDataFim())
                .build();
    }

    @Override
    public SessaoJulgamento dtoParaEntidade(SessaoJulgamentoDTO sessaoJulgamentoDTO) {
        return SessaoJulgamento.builder()
                .pauta(Pauta.builder().id(sessaoJulgamentoDTO.getIdPauta()).build())
                .dataInicio(isNull(sessaoJulgamentoDTO.getDataInicio())? LocalDateTime.now():sessaoJulgamentoDTO.getDataInicio())
                .dataFim(isNull(sessaoJulgamentoDTO.getDataFim())? LocalDateTime.now().plusMinutes(1) : sessaoJulgamentoDTO.getDataFim())
                .build();
    }
}
