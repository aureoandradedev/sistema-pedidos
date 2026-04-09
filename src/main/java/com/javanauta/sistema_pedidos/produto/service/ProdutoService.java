package com.javanauta.sistema_pedidos.produto.service;


import com.javanauta.sistema_pedidos.produto.dtos.ProdutoDTORequest;
import com.javanauta.sistema_pedidos.produto.dtos.ProdutoDTOResponse;
import com.javanauta.sistema_pedidos.produto.entity.Produto;
import com.javanauta.sistema_pedidos.produto.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoService {
    private final ProdutoRepository produtoRepository;


    public ProdutoDTOResponse criarProduto (ProdutoDTORequest produtoDTORequest){
    Produto produto = new Produto();
    produto.setPreco(produtoDTORequest.getPreco());
    produto.setNome(produtoDTORequest.getNome());
    Produto produtoSalvo = produtoRepository.save(produto);

    ProdutoDTOResponse produtoDTOResponse = new ProdutoDTOResponse();
    produtoDTOResponse.setId(produtoSalvo.getId());
    produtoDTOResponse.setPreco(produtoSalvo.getPreco());
    produtoDTOResponse.setNome(produtoSalvo.getNome());

    return  produtoDTOResponse;
    }

    public List<ProdutoDTOResponse> listaProdutos (){
        List<Produto> produtos = produtoRepository.findAll();
        List <ProdutoDTOResponse> lista = new ArrayList<>();
        for (Produto produto : produtos){
            ProdutoDTOResponse produtoDTOResponse = new ProdutoDTOResponse();
            produtoDTOResponse.setId(produto.getId());
            produtoDTOResponse.setNome(produto.getNome());
            produtoDTOResponse.setPreco(produto.getPreco());
            lista.add(produtoDTOResponse);
        }
        return lista;
    }
}
