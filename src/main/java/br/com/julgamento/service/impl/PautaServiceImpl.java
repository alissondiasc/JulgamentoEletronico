package br.com.julgamento.service.impl;

import br.com.julgamento.repository.PautaRepository;
import br.com.julgamento.service.PautaService;
import br.com.julgamento.service.mapper.PautaMapper;
import br.com.julgamento.web.rest.dto.PautaDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
@Slf4j
public class PautaServiceImpl implements PautaService {

    private PautaRepository pautaRepository;
    private PautaMapper pautaMapper;

    @Override
    public ResponseEntity<String> cadastrar(PautaDTO pautaDTO) {
        pautaRepository.save(pautaMapper.dtoParaEntidade(pautaDTO));
        return ResponseEntity.ok("Puata criada com sucesso.");
    }
}
