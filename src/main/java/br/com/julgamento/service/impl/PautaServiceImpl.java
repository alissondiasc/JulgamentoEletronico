package br.com.julgamento.service.impl;

import br.com.julgamento.domain.Pauta;
import br.com.julgamento.repository.PautaRepository;
import br.com.julgamento.service.PautaService;
import br.com.julgamento.service.mapper.PautaMapper;
import br.com.julgamento.web.rest.dto.PautaDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
@Slf4j
public class PautaServiceImpl implements PautaService {

    private PautaRepository pautaRepository;
    private PautaMapper pautaMapper;

    @Override
    public String cadastrar(PautaDTO pautaDTO) {
        pautaRepository.save(pautaMapper.dtoParaEntidade(pautaDTO));
        return "Puata criada com sucesso.";
    }

    @Override
    public Page<PautaDTO> obterPautas(Pageable pageable) {
        Page<Pauta> pautaPage = pautaRepository.findAll(pageable);
        return prepareDTO(pageable, pautaPage);
    }

    private Page<PautaDTO> prepareDTO(Pageable page, Page<Pauta> pautaPage) {
        List<PautaDTO> usuarioDTOList = pautaPage.getContent().stream().map(usuario -> pautaMapper.entidadeParaDTO(usuario)).collect(Collectors.toList());
        return new PageImpl<>(usuarioDTOList, page, pautaPage.getTotalElements());
    }
}
