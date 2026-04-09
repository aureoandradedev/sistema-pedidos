package com.javanauta.sistema_pedidos.produto.dtos;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProdutoDTORequest {
    private String nome;
    private long preco;
}
