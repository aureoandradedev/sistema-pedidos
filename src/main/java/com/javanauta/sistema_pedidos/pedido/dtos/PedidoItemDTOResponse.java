package com.javanauta.sistema_pedidos.pedido.dtos;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PedidoItemDTOResponse {
    private String nome;
    private int quantidade;
    private long preco;
}
