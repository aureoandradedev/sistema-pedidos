package com.javanauta.sistema_pedidos.pagamento.controller;

import com.javanauta.sistema_pedidos.pagamento.dtos.PagamentoDTORequest;
import com.javanauta.sistema_pedidos.pagamento.dtos.PagamentoDTOResponse;
import com.javanauta.sistema_pedidos.pagamento.service.PagamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pagamentos")
@RequiredArgsConstructor
public class PagamentoController {
    private final PagamentoService pagamentoService;

    @PostMapping
    public ResponseEntity <PagamentoDTOResponse> fazerPagamento (@RequestBody PagamentoDTORequest pagamentoDTORequest){
        return  ResponseEntity.ok(pagamentoService.processarPagamento(pagamentoDTORequest));
    }
}
