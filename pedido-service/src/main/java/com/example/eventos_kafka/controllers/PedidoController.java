package com.example.eventos_kafka.controllers;

import com.example.eventos_kafka.dtos.PedidoDto;
import com.example.eventos_kafka.models.Pedido;
import com.example.eventos_kafka.services.PedidoService;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {


    private final PedidoService pedidoService;


    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping
    public Pedido criar(@RequestBody PedidoDto dto){
        return pedidoService.criarPedido(dto);
    }

    @GetMapping
    public List<Pedido> listar(){
        return pedidoService.pegarTodos();
    }
}
