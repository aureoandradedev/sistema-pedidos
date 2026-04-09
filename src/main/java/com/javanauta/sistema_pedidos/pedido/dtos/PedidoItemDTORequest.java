package com.javanauta.sistema_pedidos.pedido.dtos;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PedidoItemDTORequest {
    private Long produtoId;
    private int quantidade;
}
