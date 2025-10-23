package com.example.eventos_kafka.producers;

import com.example.eventos_kafka.dtos.EstoqueResultEvent;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.object.StoredProcedure;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class EstoqueResultProducer {
    private final KafkaTemplate<String, EstoqueResultEvent> kafkaTemplate;

    public EstoqueResultProducer(KafkaTemplate<String, EstoqueResultEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    @Value("${app.kafka.topic-estoque-result}")
    private String topic;

    public void publicarResultado(EstoqueResultEvent event){
        kafkaTemplate.send(topic, String.valueOf(event.getPedidoId()), event);
    }
}
