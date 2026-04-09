package com.javanauta.sistema_pedidos.pagamento.dtos;

import com.javanauta.sistema_pedidos.pagamento.enums.PagamentoStatus;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PagamentoDTOResponse {
    private Long id;
    private Long pedidoId;
    private PagamentoStatus pagamentoStatus;
}
