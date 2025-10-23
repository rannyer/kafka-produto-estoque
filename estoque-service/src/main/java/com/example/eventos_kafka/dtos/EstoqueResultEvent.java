package com.example.eventos_kafka.dtos;

public class EstoqueResultEvent {
    private Long pedidoId;
    private boolean reservado;
    private String motivo;

    public EstoqueResultEvent(Long pedidoId, boolean reservado, String motivo) {
        this.pedidoId = pedidoId;
        this.reservado = reservado;
        this.motivo = motivo;
    }

    public EstoqueResultEvent() {
    }

    public Long getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Long pedidoId) {
        this.pedidoId = pedidoId;
    }

    public boolean isReservado() {
        return reservado;
    }

    public void setReservado(boolean reservado) {
        this.reservado = reservado;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
}
