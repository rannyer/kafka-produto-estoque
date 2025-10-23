package com.example.eventos_kafka.services;

import com.example.eventos_kafka.dtos.PedidoCreatedEvent;
import com.example.eventos_kafka.dtos.PedidoDto;
import com.example.eventos_kafka.enums.PedidoStatus;
import com.example.eventos_kafka.models.Pedido;
import com.example.eventos_kafka.producers.PedidoProducer;
import com.example.eventos_kafka.repositories.PedidoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {
    private final PedidoRepository pedidoRepository;
    private final PedidoProducer pedidoProducer;

    public PedidoService(PedidoRepository pedidoRepository, PedidoProducer pedidoProducer) {
        this.pedidoRepository = pedidoRepository;
        this.pedidoProducer = pedidoProducer;
    }

    @Transactional
    public Pedido criarPedido(PedidoDto dto){
        var pedido =  new Pedido();
        BeanUtils.copyProperties(dto,pedido);

        pedido.setStatus(PedidoStatus.PENDENTE);
        pedido = pedidoRepository.save(pedido);


        var evento = new PedidoCreatedEvent();
        BeanUtils.copyProperties(pedido, evento);
        pedidoProducer.publicarPedidoCriado(evento);

        return pedido;
    }
}
