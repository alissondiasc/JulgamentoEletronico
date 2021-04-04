package br.com.julgamento.service;

import br.com.julgamento.client.UsuarioClient;
import br.com.julgamento.repository.UsuarioRepository;
import br.com.julgamento.service.impl.UsuarioServiceImpl;
import br.com.julgamento.service.mapper.UsuarioMapper;
import br.com.julgamento.web.rest.dto.ResponseClientDTO;
import br.com.julgamento.web.rest.dto.UsuarioDTO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class UsuarioServiceImplTest {

    @InjectMocks
    private UsuarioServiceImpl usuarioSevice;
    @Mock
    private UsuarioClient usuarioClient;
    @Mock
    private UsuarioMapper usuarioMapper;
    @Mock
    private UsuarioRepository usuarioRepository;
    @Mock
    private UsuarioDTO usuarioDTO;
    @Mock
    private ResponseClientDTO responseClientDTOValid;
    @Mock
    private ResponseClientDTO responseClientDTOInvalid;


    @Before
    public void setUp(){
        responseClientDTOValid = ResponseClientDTO.builder()
                .status("ABLE_TO_VOTE")
                .build();
        responseClientDTOInvalid = ResponseClientDTO.builder()
                .status("UNABLE_TO_VOTE")
                .build();

        usuarioDTO = UsuarioDTO.builder()
                .CPF("037823336098")
                .nome("Teste Sucesso")
                .build();

    }

    @Test
    public void cadastrarTest(){

        when(usuarioClient.validarCPF(usuarioDTO.getCPF())).thenReturn(responseClientDTOInvalid);
        String retorno = usuarioSevice.cadastrar(this.usuarioDTO);
        assertThat(retorno).isNotNull();
        assertEquals(retorno, "CPF inválido.");
    }

    @Test
    public void cadastrarCPFInvalidoTest(){

        when(usuarioClient.validarCPF(usuarioDTO.getCPF())).thenReturn(responseClientDTOValid);
        String retorno = usuarioSevice.cadastrar(this.usuarioDTO);
        assertThat(retorno).isNotNull();
        assertEquals(retorno, "Usuario criado com sucesso.");
    }




}
