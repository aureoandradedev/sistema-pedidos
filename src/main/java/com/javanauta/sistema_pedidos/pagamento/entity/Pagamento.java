package com.javanauta.sistema_pedidos.pagamento.entity;

import com.javanauta.sistema_pedidos.pagamento.enums.PagamentoStatus;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pagamento")
@Builder
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @JoinColumn (name = "pedido_id", referencedColumnName = "id")
    private Long pedidoId;

    @Column (name = "status")
    @Enumerated(EnumType.STRING)
    private PagamentoStatus pagamentoStatus;

}
