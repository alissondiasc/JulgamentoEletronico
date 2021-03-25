package br.com.julgamento.web.rest;

import br.com.julgamento.service.VotoParticipacaoService;
import br.com.julgamento.web.rest.dto.UsuarioDTO;
import br.com.julgamento.web.rest.dto.VotoParticipacaoDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@AllArgsConstructor
@RestController
@SuppressWarnings({"java:S4834", "squid:S4834"})
@RequestMapping("voto-participacao")
public class VotoParticipacaoResource {

    private VotoParticipacaoService votoParticipacaoService;

    @PostMapping
    public ResponseEntity<String> realizarVoto(@RequestBody @Valid VotoParticipacaoDTO votoParticipacaoDTO) {
        return votoParticipacaoService.realizarVotoSessaoJulgamento(votoParticipacaoDTO);
    }
}
