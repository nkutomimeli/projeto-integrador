package com.example.demo.exception;

public class ItensCarrinhoVazioException extends RuntimeException {

    private static final long serialVersionUID = -8557903071152288334L;

    public ItensCarrinhoVazioException(String mensagem) {
        super(mensagem);
    }
}
