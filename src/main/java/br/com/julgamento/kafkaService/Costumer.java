package br.com.julgamento.kafkaService;


import br.com.julgamento.domain.SessaoJulgamento;
import br.com.julgamento.service.SessaoJulgamentoService;
import br.com.julgamento.web.rest.dto.ResultadoJulgamentoDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;

@Slf4j
@Component
@RequiredArgsConstructor
public class Costumer {
    private final ObjectMapper objectMapper;
    private final SessaoJulgamentoService sessaoJulgamentoService;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    @KafkaListener(topics = "${topic.name.producer}", groupId = "${spring.kafka.costumer.group-id}")
    public void lerMenssagemResultadoJulgamento(final String messagem){
        try{
            ResultadoJulgamentoDTO resultadoJulgamentoDTO = objectMapper.readValue(messagem, ResultadoJulgamentoDTO.class);
            SessaoJulgamento sessaoJulgamento = sessaoJulgamentoService.obterSessaoJulgamentoPorId(resultadoJulgamentoDTO.getIdJulgamento());
            log.info("A Sessão de julgamento de numero: "+sessaoJulgamento.getId()+"do dia "+sessaoJulgamento.getDataInicio().format(formatter)+"\n"+" foi encerrada. Seus resultado é: "+resultadoJulgamentoDTO.getResultadoVotacao());
        }catch (JsonProcessingException e){
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
