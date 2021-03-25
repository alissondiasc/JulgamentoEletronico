package br.com.julgamento.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "PAUTA")
public class Pauta  implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private String tema;
    private byte[] assunto;

}
