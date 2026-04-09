package com.javanauta.sistema_pedidos.pedido.entity;

import com.javanauta.sistema_pedidos.pedido.enums.Status;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "pedido")
@Builder
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "dataCriacao")
    @CreationTimestamp
    private LocalDateTime dataCriacao;

    @Column (name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToMany (cascade = CascadeType.ALL)
    @JoinColumn (name = "pedido_id", referencedColumnName = "id")
    private List<PedidoItem> pedidoItens;

}
