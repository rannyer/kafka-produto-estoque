package com.example.eventos_kafka.consumer;

import com.example.eventos_kafka.dtos.EstoqueResultEvent;
import com.example.eventos_kafka.dtos.PedidoCreatedEvent;
import com.example.eventos_kafka.models.ProdutoEstoque;
import com.example.eventos_kafka.producers.EstoqueResultProducer;
import com.example.eventos_kafka.repositories.ProdutoEstoqueRepository;
import jakarta.transaction.Transactional;
import org.aspectj.lang.annotation.RequiredTypes;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class PedidoCreatedConsumer {
    private final ProdutoEstoqueRepository repo;
    private final EstoqueResultProducer resultProducer;



    public PedidoCreatedConsumer(ProdutoEstoqueRepository repo, EstoqueResultProducer resultProducer) {
        this.repo = repo;
        this.resultProducer = resultProducer;
    }

    @Transactional
    @KafkaListener(topics = "${app.kafka.topic-pedido-created}", groupId = "${spring.kafka.consumer.group-id}")
    public void consumirPedido(PedidoCreatedEvent event){
        System.out.println("ID PRODUTO" + event.getProdutoId());
        var produto = repo.findById(event.getProdutoId())
                .orElseGet(() -> repo.save(new ProdutoEstoque(event.getProdutoId(),0)));

        System.out.println("CONSUMER PEDIDO ID"+event.getPedidoId());


        boolean reservado =false;
        String motivo = null;

        if(produto.getQuantidadeDisponivel() >= event.getQuantidade()){
            produto.setQuantidadeDisponivel(produto.getQuantidadeDisponivel() - event.getQuantidade());
            reservado = true;
        }else{
            motivo = "Estoque insuficiente";
        }

        repo.save(produto);
        resultProducer.publicarResultado(new EstoqueResultEvent(event.getPedidoId(), reservado, motivo));
    }
}
