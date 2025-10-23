package com.example.eventos_kafka.producers;

import com.example.eventos_kafka.dtos.PedidoCreatedEvent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class PedidoProducer {
    private final KafkaTemplate<String, PedidoCreatedEvent> kafkaTemplate;

    public PedidoProducer(KafkaTemplate<String, PedidoCreatedEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Value("${app.kafka.topic-pedido-created}")
    private String topic;

    public void publicarPedidoCriado(PedidoCreatedEvent event){
        kafkaTemplate.send(topic, String.valueOf(event.getPedidoId()), event );
    }
}
