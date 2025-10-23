package com.example.eventos_kafka.dtos;

public class PedidoCreatedEvent {
    private Long pedidoId;
    private Long produtoId;
    private Integer quantidade;

    public PedidoCreatedEvent() {
    }

    public PedidoCreatedEvent(Long pedidoId, Long produtoId, Integer quantidade) {
        this.pedidoId = pedidoId;
        this.produtoId = produtoId;
        this.quantidade = quantidade;
    }

    public Long getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Long pedidoId) {
        this.pedidoId = pedidoId;
    }

    public Long getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Long produtoId) {
        this.produtoId = produtoId;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
