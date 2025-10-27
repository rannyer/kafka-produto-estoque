package com.example.eventos_kafka.consumer;

import com.example.eventos_kafka.dtos.EstoqueResultEvent;
import com.example.eventos_kafka.enums.PedidoStatus;
import com.example.eventos_kafka.repositories.PedidoRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class EstoqueResultConsumer {
 private final PedidoRepository pedidoRepository;

    public EstoqueResultConsumer(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @KafkaListener(topics = "${app.kafka.topic-estoque-result}", groupId = "${spring.kafka.consumer.group-id}")
    public void consumirResultado(EstoqueResultEvent event){
        System.out.println("ID" + event.getPedidoId());
        var pedido = pedidoRepository.findById(event.getPedidoId())
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));

        if(event.isReservado()){
            pedido.setStatus(PedidoStatus.CONFIRMADO);
        }else{
            pedido.setStatus(PedidoStatus.RECUSADO);
        }

        pedidoRepository.save(pedido);
        System.out.println("FUNCIONOU");
    }
}
