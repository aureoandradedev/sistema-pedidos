package com.javanauta.sistema_pedidos.pedido.dtos;

import com.javanauta.sistema_pedidos.pedido.enums.Status;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PedidoDTOResponse {
    private Long id;
    private Status status;
    private LocalDateTime dataCriacao;
    private List<PedidoItemDTOResponse> pedidosItens;

}
