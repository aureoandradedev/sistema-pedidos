package com.javanauta.sistema_pedidos.produto.controller;

import com.javanauta.sistema_pedidos.produto.dtos.ProdutoDTORequest;
import com.javanauta.sistema_pedidos.produto.dtos.ProdutoDTOResponse;
import com.javanauta.sistema_pedidos.produto.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
@RequiredArgsConstructor
public class ProdutoController {
    private final ProdutoService produtoService;

    @PostMapping
    public ResponseEntity <ProdutoDTOResponse> criarProduto (@RequestBody ProdutoDTORequest produtoDTORequest){
        return  ResponseEntity.ok(produtoService.criarProduto(produtoDTORequest));
    }

    @GetMapping
    public ResponseEntity <List<ProdutoDTOResponse>> listarProdutos (){
        return ResponseEntity.ok(produtoService.listaProdutos());
    }
}
