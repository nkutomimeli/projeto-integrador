package com.example.demo.dto;

import com.example.demo.entity.Anuncio;
import com.example.demo.entity.Carrinho;
import com.example.demo.entity.ItemCarrinho;
import lombok.*;
import org.springframework.validation.annotation.Validated;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Validated
public class ItemCarrinhoDTO {

    private Long anuncio_id;
    private Integer quantidade;

    public static ItemCarrinho converte(ItemCarrinhoDTO dto, Anuncio anuncio, Carrinho carrinho) {
        return ItemCarrinho.builder()
                .anuncio(anuncio)
                .carrinho(carrinho)
                .quantidade(dto.getQuantidade())
                .preco(anuncio.getPreco())
                .build();
    }
}
