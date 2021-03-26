package br.com.julgamento.service.mapper;

import br.com.julgamento.domain.Usuario;
import br.com.julgamento.web.rest.dto.UsuarioDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class UsuarioMapper implements AbstractMapper<Usuario, UsuarioDTO> {

    @Override
    public UsuarioDTO entidadeParaDTO(Usuario entidade) {
        return UsuarioDTO.builder()
                .id(entidade.getId())
                .nome(entidade.getNome())
                .CPF(entidade.getCpf())
                .build();
    }

    @Override
    public Usuario dtoParaEntidade(UsuarioDTO entidade) {
        return Usuario.builder()
                .nome(entidade.getNome())
                .cpf(entidade.getCPF())
                .build();
    }
}
