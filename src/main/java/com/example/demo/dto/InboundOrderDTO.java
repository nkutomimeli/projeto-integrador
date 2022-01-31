package com.example.demo.dto;

import com.example.demo.entity.OrdemEntrada;
import lombok.*;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InboundOrderDTO {
    private OrdemEntradaDTO ordemEntradaDTO;
    private Set<EstoqueDTO> listaEstoqueDTO;

    public static InboundOrderDTO converte(OrdemEntrada ordemEntrada){
        OrdemEntradaDTO ordemEntradaDTO = new OrdemEntradaDTO(ordemEntrada.getDataCriacao(), ordemEntrada.getId());
        Set<EstoqueDTO> listaEstoque = EstoqueDTO.converte(ordemEntrada.getEstoques());

        InboundOrderDTO dto = InboundOrderDTO.builder()
                .ordemEntradaDTO(ordemEntradaDTO)
                .listaEstoqueDTO(listaEstoque)
                .build();
        return dto;
    }
}
