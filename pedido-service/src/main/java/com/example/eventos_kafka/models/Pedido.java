package com.example.eventos_kafka.models;

import com.example.eventos_kafka.enums.PedidoStatus;
import jakarta.persistence.*;

@Entity
@Table(name = "pedidos")
public class Pedido {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long produtoId;

    private Integer quantidade;

    @Enumerated(EnumType.STRING)
    private PedidoStatus status;

    public Pedido() {
    }

    public Pedido(Long id, Long produtoId, Integer quantidade, PedidoStatus status) {
        this.id = id;
        this.produtoId = produtoId;
        this.quantidade = quantidade;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public PedidoStatus getStatus() {
        return status;
    }

    public void setStatus(PedidoStatus status) {
        this.status = status;
    }
}
