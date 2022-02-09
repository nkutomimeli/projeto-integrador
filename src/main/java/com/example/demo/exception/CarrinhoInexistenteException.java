package com.example.demo.exception;

public class CarrinhoInexistenteException extends RuntimeException {

    private static final long serialVersionUID = 6888396620777951584L;

    public CarrinhoInexistenteException(String mensagem) {
        super(mensagem);
    }

}
