package com.javanauta.sistema_pedidos.pedido.controller;

import com.javanauta.sistema_pedidos.pedido.dtos.PedidoDTORequest;
import com.javanauta.sistema_pedidos.pedido.dtos.PedidoDTOResponse;
import com.javanauta.sistema_pedidos.pedido.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/pedidos")
@RequiredArgsConstructor
public class PedidoController {
    private final PedidoService pedidoService;

    @PostMapping
    public ResponseEntity <PedidoDTOResponse> criarPedido (@RequestBody PedidoDTORequest pedidoDTORequest){
        return  ResponseEntity.ok(pedidoService.criarPedido(pedidoDTORequest));
    }

}
