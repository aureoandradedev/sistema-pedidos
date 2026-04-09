package com.javanauta.sistema_pedidos.pagamento.dtos;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PagamentoDTORequest {
    private Long pedidoId;
}
