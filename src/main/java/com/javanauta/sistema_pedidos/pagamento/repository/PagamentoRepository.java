package com.javanauta.sistema_pedidos.pagamento.repository;

import com.javanauta.sistema_pedidos.pagamento.entity.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PagamentoRepository extends JpaRepository <Pagamento, Long> {
    Optional<Pagamento> findByPedidoId(Long pedidoId);
    boolean existsByPedidoId(Long pedidoId);
}
