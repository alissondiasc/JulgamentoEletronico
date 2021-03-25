package br.com.julgamento.service.impl;

import br.com.julgamento.client.UsuarioClient;
import br.com.julgamento.repository.UsuarioRepository;
import br.com.julgamento.service.UsuarioSevice;
import br.com.julgamento.service.mapper.UsuarioMapper;
import br.com.julgamento.web.rest.dto.ResponseClientDTO;
import br.com.julgamento.web.rest.dto.UsuarioDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
@Slf4j
public class UsuarioServiceImpl implements UsuarioSevice {

    private UsuarioRepository usuarioRepository;
    private UsuarioMapper usuarioMapper;
    private UsuarioClient usuarioClient;

    @Override
    public ResponseEntity<String> cadastrar(UsuarioDTO usuarioDTO) {
        try{
            usuarioDTO.setCPF(usuarioDTO.getCPF().replaceAll("[^0-9]", ""));
            EntityModel<ResponseClientDTO> responseClientDTO =usuarioClient.validarCPF(usuarioDTO.getCPF());
            if(responseClientDTO.getContent().isValido()){
                usuarioRepository.save(usuarioMapper.dtoParaEntidade(usuarioDTO));
                return ResponseEntity.ok("Usuario criado com sucesso.");
            }
            return ResponseEntity.ok("CPF inválido.");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
