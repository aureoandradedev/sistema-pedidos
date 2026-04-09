package com.javanauta.sistema_pedidos.produto.dtos;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProdutoDTOResponse {
    private Long id;
    private String nome;
    private long preco;
}
