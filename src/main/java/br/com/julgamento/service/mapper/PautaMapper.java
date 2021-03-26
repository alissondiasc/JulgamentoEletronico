package br.com.julgamento.service.mapper;

import br.com.julgamento.domain.Pauta;
import br.com.julgamento.web.rest.dto.PautaDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import static br.com.julgamento.util.TextoUtil.convertStringToByte;

@AllArgsConstructor
@Component
public class PautaMapper  implements AbstractMapper<Pauta, PautaDTO> {

    @Override
    public PautaDTO entidadeParaDTO(Pauta entidade) {
        return PautaDTO.builder()
                .id(entidade.getId())
                .tema(entidade.getTema())
                .assunto(convertStringToByte(entidade.getAssunto()))
                .build();
    }

    @Override
    public Pauta dtoParaEntidade(PautaDTO pautaDTO) {
        return Pauta.builder()
                .tema(pautaDTO.getTema())
                .assunto(pautaDTO.getAssunto().getBytes())
                .build();
    }
}
