package com.example.demo.dto;

import com.example.demo.entity.Carrinho;
import com.example.demo.entity.Comprador;
import com.example.demo.enums.Status;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDateTime;
import java.util.Set;

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
    private Set<ItemCarrinhoDTO> listaAnuncio;

    public static Carrinho converte(CarrinhoDTO dto, Comprador comprador) {
        return Carrinho.builder()
                .comprador(comprador)
                .dataCriacao(dto.getDataCriacao())
                .status(dto.getStatus().getCodigo())
                .build();
    }

    public static CarrinhoDTO converte(Carrinho carrinho) {
        return CarrinhoDTO.builder()
                .dataCriacao(carrinho.getDataCriacao())
                .comprador_id(carrinho.getComprador().getId())
                .status(Status.toEnum(carrinho.getStatus()))
                .listaAnuncio(ItemCarrinhoDTO.converte(carrinho.getItensCarrinho()))
                .build();
    }
}
