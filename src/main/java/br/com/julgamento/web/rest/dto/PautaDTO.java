package br.com.julgamento.web.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class PautaDTO  implements Serializable {

    private static final long serialVersionUID = 1L;
    @NotBlank(message = "Campo tema é de preenchimento obrigatório")
    private String tema;
    @NotBlank(message = "Campo assunto é de preenchimento obrigatório")
    private String assunto;
}
