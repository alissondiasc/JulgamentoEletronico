package br.com.julgamento.web.rest.dto;

import br.com.julgamento.domain.enums.Indicador;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
public class VotoParticipacaoDTO {

    @NotBlank(message = "Campo idJulgamento é de preenchimento obrigatório")
    private String idJulgamento;
    @NotBlank(message = "Campo idAssociado é de preenchimento obrigatório")
    private String idAssociado;
    @NotNull(message = "Campo votoParticipacao é de preenchimento obrigatório")
    private Indicador votoParticipacao;
}
