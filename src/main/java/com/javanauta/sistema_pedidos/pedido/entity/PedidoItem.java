package com.javanauta.sistema_pedidos.pedido.entity;

import com.javanauta.sistema_pedidos.produto.entity.Produto;
import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "pedido_item")
@Builder
public class PedidoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "quantidade")
    private int quantidade;

    @Column (name = "preco")
    private long preco;

    @ManyToOne
    @JoinColumn (name = "produto_id", referencedColumnName = "id")
    private Produto produto;
}
