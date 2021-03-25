package br.com.julgamento.domain;

import br.com.julgamento.domain.enums.ResultadoVotacao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "RESULTADO_JULGAMENTO")
public class ResultadoJulgamento {

    @Id
    private String id;
    @DBRef
    private SessaoJulgamento sessaoJulgamento;
    private ResultadoVotacao resultadoVotacao;


}
