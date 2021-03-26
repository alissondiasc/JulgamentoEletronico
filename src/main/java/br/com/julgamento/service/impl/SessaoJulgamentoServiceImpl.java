package br.com.julgamento.service.impl;

import br.com.julgamento.domain.SessaoJulgamento;
import br.com.julgamento.domain.enums.Indicador;
import br.com.julgamento.repository.SessaoJulgamentoRepository;
import br.com.julgamento.service.SessaoJulgamentoService;
import br.com.julgamento.service.mapper.SessaoJulgamentoMapper;
import br.com.julgamento.web.rest.dto.SessaoJulgamentoDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;


@AllArgsConstructor
@Service
@Slf4j
public class SessaoJulgamentoServiceImpl implements SessaoJulgamentoService {

    private SessaoJulgamentoRepository sessaoJulgamentoRepository;
    private SessaoJulgamentoMapper sessaoJulgamentoMapper;

    @Override
    public String cadastrar(SessaoJulgamentoDTO sessaoJulgamentoDTO) {
        validarData(sessaoJulgamentoDTO.getDataFim(), "Data fim não pode ser anterior a data e hora atual.");
        validarData(sessaoJulgamentoDTO.getDataInicio(), "Data de início não pode ser anterior a data e hora atual.");
        SessaoJulgamento sessaoJulgamento = sessaoJulgamentoMapper.dtoParaEntidade(sessaoJulgamentoDTO);
        atualizarIndicador(sessaoJulgamento, Indicador.S);
        return "Operação realizada com sucesso.";
    }

    public void validarData(LocalDateTime data, String msg) {
        if (nonNull(data)) {
            LocalDateTime now = LocalDateTime.now();
            if (data.isBefore(now)) {
                throw new ValidationException(msg);
            }
        }
    }

    @Override
    public SessaoJulgamento obterSessaoJulgamentoPorId(String idSessaoJulgamento) throws Exception {
        return sessaoJulgamentoRepository.findById(idSessaoJulgamento).orElseThrow(() -> new Exception("Não existe sessão julgamento com esse id"));
    }


    @Override
    public void atualizarIndicador(SessaoJulgamento sessaoJulgamento, Indicador n) {
        sessaoJulgamento.setIndSessaoAberta(n);
        sessaoJulgamentoRepository.save(sessaoJulgamento);
    }

    @Override
    public Page<SessaoJulgamentoDTO> obterSessoesJulgamentos(Pageable pageable) {
        Page<SessaoJulgamento> pautaPage = sessaoJulgamentoRepository.findAll(pageable);
        return prepareDTO(pageable, pautaPage);
    }

    private Page<SessaoJulgamentoDTO> prepareDTO(Pageable page, Page<SessaoJulgamento> sessaoJulgamentoPage) {
        List<SessaoJulgamentoDTO> usuarioDTOList = sessaoJulgamentoPage.getContent().stream().map(usuario -> sessaoJulgamentoMapper.entidadeParaDTO(usuario)).collect(Collectors.toList());
        return new PageImpl<>(usuarioDTOList, page, sessaoJulgamentoPage.getTotalElements());
    }
}
