package com.example.demo.exception;

public class ProdutoVazioException extends RuntimeException {

    private static final long serialVersionUID = 616106877599865115L;

    public ProdutoVazioException(String mensagem) {
        super(mensagem);
    }

}
