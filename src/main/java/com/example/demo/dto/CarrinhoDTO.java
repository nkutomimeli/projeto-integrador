package com.example.demo.dto;

import com.example.demo.entity.Carrinho;
import com.example.demo.entity.Comprador;
import com.example.demo.enums.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Validated
public class CarrinhoDTO {

    private LocalDateTime dataCriacao;
    private Long comprador_id;
    private Status status;
    private List<ItemCarrinhoDTO> listaAnuncio;

    public static Carrinho converte(CarrinhoDTO dto, Comprador comprador) {
        return Carrinho.builder()
                .comprador(comprador)
                .dataCriacao(dto.getDataCriacao())
                .status(dto.getStatus().getCodigo())
                .build();
    }
}
