package br.com.julgamento.service;

import br.com.julgamento.web.rest.dto.UsuarioDTO;
import org.springframework.http.ResponseEntity;

public interface UsuarioSevice {

    ResponseEntity<String> cadastrar(UsuarioDTO usuarioDTO);
}
