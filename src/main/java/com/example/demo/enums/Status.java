package com.example.demo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Status {
    CART (0, "Cart");

    private int codigo;
    private String descricao;

    public static Tipos toEnum(Integer codigo) {
        if (codigo == null) {
            return null;
        }

        for (Tipos t: Tipos.values()) {
            if (codigo.equals(t.getCodigo())) {
                return t;
            }
        }

        throw new IllegalArgumentException("Código do status inválido.");

    }
}
