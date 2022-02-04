package com.example.demo.dto;

import com.example.demo.entity.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Validated
public class ListaArmazemDTO {

    private Long armazem_id;

    private Integer totalQuantidade;

    /*
    public static ListaArmazemDTO converte(Armazem armazem, Estoque estoque) {
        return ListaArmazemDTO.builder()
                .armazem_id(armazem.getId())
                .totalQuantidade(estoque.getQuantidadeAtual())
                .build();
    }
     */
}
