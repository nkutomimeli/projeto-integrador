package com.example.demo.dto;

import com.example.demo.entity.Armazem;
import com.example.demo.entity.Estoque;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Validated
public class ArmazemDTO {

    private Long estoque_id;

    private List<ListaArmazemDTO> listArmazem;

    /*
    public static ArmazemDTO converte(ListaArmazemDTO listaArmazemDTO, Estoque estoque) {
        return ArmazemDTO.builder()
                .estoque_id(estoque.getId())
                .listArmazem(listaArmazemDTO.getArmazem_id())
                .build();
    }
     */
}
