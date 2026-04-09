package com.javanauta.sistema_pedidos.produto.repository;


import com.javanauta.sistema_pedidos.produto.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface ProdutoRepository extends JpaRepository <Produto, Long> {


}
