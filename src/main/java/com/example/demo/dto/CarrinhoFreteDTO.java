package com.example.demo.dto;

import com.example.demo.entity.Anuncio;
import com.example.demo.entity.Comprador;
import com.example.demo.entity.ItemCarrinho;
import com.example.demo.enums.Status;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarrinhoFreteDTO {

    private Long id;
    private Long comprador;
    private int status;
    private PrecoDTO preco;
//    private List<ItemCarrinho> itensCarrinho;

}
