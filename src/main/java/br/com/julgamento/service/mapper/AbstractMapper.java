package br.com.julgamento.service.mapper;


import br.com.julgamento.domain.Pauta;
import br.com.julgamento.domain.Usuario;
import br.com.julgamento.web.rest.dto.PautaDTO;
import br.com.julgamento.web.rest.dto.UsuarioDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

interface AbstractMapper<CLASSE, DTO> {

    default List<DTO> entidadesParaDTOs(List<CLASSE> entidades) {
        return entidades.stream()
                .filter(Objects::nonNull)
                .map(this::entidadeParaDTO)
                .collect(Collectors.toList());
    }

    default List<CLASSE> dtosParaEntidades(List<DTO> dtos) {
        return dtos.stream()
                .filter(Objects::nonNull)
                .map(this::dtoParaEntidade)
                .collect(Collectors.toList());
    }

    DTO entidadeParaDTO(CLASSE entidade);

    CLASSE dtoParaEntidade(DTO dto);

    default Page<DTO> pageEntidadeParaPageDTO(Page<CLASSE> entidade) {
        return entidade.map(this::entidadeParaDTO);
    }


}

