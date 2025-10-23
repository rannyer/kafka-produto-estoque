package com.example.eventos_kafka.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ProdutoEstoque {
    @Id
    private Long id;
    private Integer quantidadeDisponivel;

    public ProdutoEstoque(Long id, Integer quantidadeDisponivel) {
        this.id = id;
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    public ProdutoEstoque() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }

    public void setQuantidadeDisponivel(Integer quantidadeDisponivel) {
        this.quantidadeDisponivel = quantidadeDisponivel;
    }
}

