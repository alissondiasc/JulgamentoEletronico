package br.com.julgamento.service.mapper;

import br.com.julgamento.domain.SessaoJulgamento;
import br.com.julgamento.domain.Usuario;
import br.com.julgamento.domain.VotoParticipacao;
import br.com.julgamento.web.rest.dto.UsuarioDTO;
import br.com.julgamento.web.rest.dto.VotoParticipacaoDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@AllArgsConstructor
@Component
public class VotoParticipacaoMapper  implements AbstractMapper<VotoParticipacao, VotoParticipacaoDTO> {
    @Override
    public VotoParticipacaoDTO entidadeParaDTO(VotoParticipacao entidade) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return VotoParticipacaoDTO.builder()
                .idAssociado(entidade.getAssociado().getId())
                .nomeAssociado(entidade.getAssociado().getNome())
                .votoParticipacao(entidade.getVoto())
                .dataHoraSessaoJulgamento(entidade.getSessaoJulgamento().getDataInicio().format(formatter))
                .pautaJulgada(entidade.getSessaoJulgamento().getPauta().getTema())
                .idJulgamento(entidade.getSessaoJulgamento().getId())
                .build();
    }

    @Override
    public VotoParticipacao dtoParaEntidade(VotoParticipacaoDTO votoParticipacaoDTO) {
        return VotoParticipacao.builder()
                .associado(Usuario.builder().id(votoParticipacaoDTO.getIdAssociado()).build())
                .sessaoJulgamento(SessaoJulgamento.builder().id(votoParticipacaoDTO.getIdJulgamento()).build())
                .voto(votoParticipacaoDTO.getVotoParticipacao())
                .build();
    }
}
