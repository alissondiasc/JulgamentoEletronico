package br.com.julgamento.web.rest.dto;

import lombok.*;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class DetalhesResultadoJulgamentoDTO {

    private String idJulgamento;

    private PautaDTO pautaDTO;

    private long votosContras;

    private long votosFavoraveis;

    private String resultadojulamento;

    private String dataJulgamento;

}
