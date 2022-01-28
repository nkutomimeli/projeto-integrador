package com.example.demo.dto;

import lombok.*;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InboundOrderDTO {
    private OrdemEntradaDTO ordemEntradaDTO;
    private Set<EstoqueDTO> listaEstoqueDTO;
}
