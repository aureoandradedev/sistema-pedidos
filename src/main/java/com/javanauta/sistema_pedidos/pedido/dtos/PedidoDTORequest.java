package com.javanauta.sistema_pedidos.pedido.dtos;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class PedidoDTORequest {
   private List<PedidoItemDTORequest> pedidosItens;
}
