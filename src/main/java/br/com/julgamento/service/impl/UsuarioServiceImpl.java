package br.com.julgamento.service.impl;

import br.com.julgamento.client.UsuarioClient;
import br.com.julgamento.domain.Usuario;
import br.com.julgamento.repository.UsuarioRepository;
import br.com.julgamento.service.UsuarioSevice;
import br.com.julgamento.service.mapper.UsuarioMapper;
import br.com.julgamento.web.rest.dto.ResponseClientDTO;
import br.com.julgamento.web.rest.dto.UsuarioDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
@Slf4j
public class UsuarioServiceImpl implements UsuarioSevice {

    private UsuarioRepository usuarioRepository;
    private UsuarioMapper usuarioMapper;
    private UsuarioClient usuarioClient;

    @Override
    public String cadastrar(UsuarioDTO usuarioDTO) {

        usuarioDTO.setCPF(usuarioDTO.getCPF().replaceAll("[^0-9]", ""));
        ResponseClientDTO responseClientDTO = usuarioClient.validarCPF(usuarioDTO.getCPF());
        if (responseClientDTO.isValido()) {
            usuarioRepository.save(usuarioMapper.dtoParaEntidade(usuarioDTO));
            return "Usuario criado com sucesso.";
        }
        return "CPF inválido.";
    }

    @Override
    public ResponseClientDTO validarCpf(String cpf) {
        String novoCpf = cpf.replaceAll("[^0-9]", "");
        if (novoCpf.length() == 11) {
            return usuarioClient.validarCPF(novoCpf);
        }
        throw new ValidationException("CPF inválido");

    }

    @Override
    public Page<UsuarioDTO> obterUsuario(Pageable pageable) {
        return usuarioMapper.pageEntidadeParaPageDTO(usuarioRepository.findAll(pageable));
    }
}
