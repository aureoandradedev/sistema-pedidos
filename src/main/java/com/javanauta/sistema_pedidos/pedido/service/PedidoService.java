package com.javanauta.sistema_pedidos.pedido.service;

import com.javanauta.sistema_pedidos.exceptions.ResourceNotFoundExeception;
import com.javanauta.sistema_pedidos.pagamento.service.PagamentoService;
import com.javanauta.sistema_pedidos.pedido.dtos.PedidoDTORequest;
import com.javanauta.sistema_pedidos.pedido.dtos.PedidoDTOResponse;
import com.javanauta.sistema_pedidos.pedido.dtos.PedidoItemDTORequest;
import com.javanauta.sistema_pedidos.pedido.dtos.PedidoItemDTOResponse;
import com.javanauta.sistema_pedidos.pedido.entity.Pedido;
import com.javanauta.sistema_pedidos.pedido.entity.PedidoItem;
import com.javanauta.sistema_pedidos.pedido.enums.Status;
import com.javanauta.sistema_pedidos.pedido.repository.PedidoRepository;
import com.javanauta.sistema_pedidos.produto.entity.Produto;
import com.javanauta.sistema_pedidos.produto.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PedidoService {
    private final PedidoRepository pedidoRepository;
    private final ProdutoRepository produtoRepository;


    public PedidoDTOResponse criarPedido(PedidoDTORequest request) {
        List<PedidoItem> pedidoItemList = new ArrayList<>();
        for (PedidoItemDTORequest pedidoItemDTORequest : request.getPedidosItens()) {
            Produto produto = produtoRepository.findById(pedidoItemDTORequest.getProdutoId())
                    .orElseThrow(() -> new ResourceNotFoundExeception("Produto não encontrado"));


            PedidoItem pedidoItem1 = new PedidoItem();
            pedidoItem1.setProduto(produto);
            pedidoItem1.setQuantidade(pedidoItemDTORequest.getQuantidade());
            pedidoItem1.setPreco(produto.getPreco());
            pedidoItemList.add(pedidoItem1);
        }

        Pedido pedido = new Pedido();
        pedido.setPedidoItens(pedidoItemList);
        pedido.setStatus(Status.PENDENTE);
        Pedido pedidoSalvo = pedidoRepository.save(pedido);

        List<PedidoItemDTOResponse> pedidoItemDTOResponseList = new ArrayList<>();
        for (PedidoItem pedidoItem : pedidoSalvo.getPedidoItens()) {
            PedidoItemDTOResponse pedidoItemDTOResponse = new PedidoItemDTOResponse();
            pedidoItemDTOResponse.setNome((pedidoItem.getProduto().getNome()));
            pedidoItemDTOResponse.setQuantidade(pedidoItem.getQuantidade());
            pedidoItemDTOResponse.setPreco(pedidoItem.getPreco());
            pedidoItemDTOResponseList.add(pedidoItemDTOResponse);
        }

        PedidoDTOResponse pedidoDTOResponse = new PedidoDTOResponse();
        pedidoDTOResponse.setId(pedidoSalvo.getId());
        pedidoDTOResponse.setStatus(pedidoSalvo.getStatus());
        pedidoDTOResponse.setDataCriacao(pedidoSalvo.getDataCriacao());
        pedidoDTOResponse.setPedidosItens(pedidoItemDTOResponseList);
        return pedidoDTOResponse;
    }

    public void atualizarStatus(Long pedidoId, Status status) {
        Pedido entity = pedidoRepository.findById(pedidoId).orElseThrow(() ->
                new ResourceNotFoundExeception("Id não encontrado " + pedidoId));
        entity.setStatus(status);
        pedidoRepository.save(entity);
    }

    public Pedido buscarPedidoPorId(Long pedidoId) {
        Pedido pedido = pedidoRepository.findById(pedidoId).orElseThrow(
                () -> new ResourceNotFoundExeception("Id não encontrado"));
        return pedido;
    }
}


