package com.javanauta.sistema_pedidos.pagamento.service;

import com.javanauta.sistema_pedidos.exceptions.ConflictException;
import com.javanauta.sistema_pedidos.pagamento.dtos.PagamentoDTORequest;
import com.javanauta.sistema_pedidos.pagamento.dtos.PagamentoDTOResponse;
import com.javanauta.sistema_pedidos.pagamento.entity.Pagamento;
import com.javanauta.sistema_pedidos.pagamento.enums.PagamentoStatus;
import com.javanauta.sistema_pedidos.pagamento.repository.PagamentoRepository;
import com.javanauta.sistema_pedidos.pedido.entity.Pedido;
import com.javanauta.sistema_pedidos.pedido.enums.Status;
import com.javanauta.sistema_pedidos.pedido.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PagamentoService {
    private final PagamentoRepository pagamentoRepository;
    private final PedidoService pedidoService;



    @Transactional
    public PagamentoDTOResponse processarPagamento(PagamentoDTORequest pagamentoDTORequest) {

        Pedido pedido = pedidoService.buscarPedidoPorId(pagamentoDTORequest.getPedidoId());

        if (pedido.getStatus() == Status.CONFIRMADO) {
            throw new ConflictException("Pagamento já realizado");
        }

        if (pedido.getStatus() == Status.CANCELADO) {
            throw new ConflictException("Pedido cancelado");
        }

        if (verificaPagamentoExistente(pagamentoDTORequest.getPedidoId())) {
            throw new ConflictException("Pagamento já realizado");
        }

        PagamentoStatus pagamentoStatus =
                Math.random() < 0.5 ? PagamentoStatus.APROVADO : PagamentoStatus.CANCELADO;

        Pagamento pagamento = new Pagamento();
        pagamento.setPedidoId(pagamentoDTORequest.getPedidoId());
        pagamento.setPagamentoStatus(pagamentoStatus);

        Pagamento pagamentoSalvo = pagamentoRepository.save(pagamento);

        if (pagamentoStatus == PagamentoStatus.APROVADO) {
            pedidoService.atualizarStatus(pagamentoSalvo.getPedidoId(), Status.CONFIRMADO);
        } else {
            pedidoService.atualizarStatus(pagamentoSalvo.getPedidoId(), Status.CANCELADO);
        }

        PagamentoDTOResponse response = new PagamentoDTOResponse();
        response.setId(pagamentoSalvo.getId());
        response.setPedidoId(pagamentoSalvo.getPedidoId());
        response.setPagamentoStatus(pagamentoSalvo.getPagamentoStatus());

        return response;
    }

    public boolean verificaPagamentoExistente(Long pedidoId) {
        return pagamentoRepository.existsByPedidoId(pedidoId);
    }


}
