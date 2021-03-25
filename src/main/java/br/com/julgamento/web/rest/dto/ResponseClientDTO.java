package br.com.julgamento.web.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class ResponseClientDTO  implements Serializable  {

    private static final long serialVersionUID = 1L;

    public static final String VALIDO = "ABLE_TO_VOTE";
    public static final String INVALIDO = "UNABLE_TO_VOTE";
    private String status;

    public boolean isValido() {
        return status.equals(VALIDO);
    }
}
