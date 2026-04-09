package com.javanauta.sistema_pedidos.exceptions;

public class ResourceNotFoundExeception extends RuntimeException {

    public ResourceNotFoundExeception(String message) {
        super(message);

    }

    public ResourceNotFoundExeception(String mensagem, Throwable throwable) {
        super(mensagem);
    }
}