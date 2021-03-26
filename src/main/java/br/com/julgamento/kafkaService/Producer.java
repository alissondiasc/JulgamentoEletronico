package br.com.julgamento.kafkaService;

import br.com.julgamento.web.rest.dto.ResultadoJulgamentoDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class Producer {
    @Value("${topic.name.producer}")
    private String topicName;

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    public void send(ResultadoJulgamentoDTO resultadoJulgamentoDTO){
        final String message = objectToJson(resultadoJulgamentoDTO);
        log.info("Payload enviado: {resultadoJulgamento}", message);
        kafkaTemplate.send(topicName, message);
    }

    private String objectToJson(ResultadoJulgamentoDTO resultadoJulgamentoDTO) {
        try{
            return objectMapper.writeValueAsString(resultadoJulgamentoDTO);
        }catch (JsonProcessingException e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
