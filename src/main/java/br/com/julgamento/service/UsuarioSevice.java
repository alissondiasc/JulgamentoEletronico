package br.com.julgamento.service;

import br.com.julgamento.web.rest.dto.ResponseClientDTO;
import br.com.julgamento.web.rest.dto.UsuarioDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;

public interface UsuarioSevice {

    String cadastrar(UsuarioDTO usuarioDTO);

    ResponseClientDTO validarCpf(String cpf);

    Page<UsuarioDTO> obterUsuario(Pageable pageable);
}
