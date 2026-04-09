package com.javanauta.sistema_pedidos.pedido.repository;

import com.javanauta.sistema_pedidos.pedido.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository <Pedido, Long> {


}
