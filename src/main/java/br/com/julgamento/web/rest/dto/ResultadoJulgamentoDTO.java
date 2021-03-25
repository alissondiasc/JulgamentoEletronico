package br.com.julgamento.web.rest.dto;

import br.com.julgamento.domain.SessaoJulgamento;
import br.com.julgamento.domain.enums.ResultadoVotacao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class ResultadoJulgamentoDTO {


    @NotBlank(message = "Campo idJulgamento é de preenchimento obrigatório.")
    private String  idJulgamento;
    private String resultadoVotacao;
}
