package com.example.eventos_kafka.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record PedidoDto(@NotNull Long produtoId, @Min(1) Integer quantidade) {
}
