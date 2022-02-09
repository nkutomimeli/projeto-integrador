package com.example.demo.utils;

import com.example.demo.entity.*;
import com.example.demo.enums.Tipos;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
public class MockAnuncios {

    private List<Anuncio> anuncios = new ArrayList<>();

    public MockAnuncios() {
        Vendedor vendedor1 = Vendedor.builder()
                .id(1L)
                .nome("Juliana")
                .build();

        Produto produto1 = Produto.builder()
                .id(1L)
                .nome("Maçã")
                .descricao("Maçã orgânica")
                .build();

        Anuncio anuncio1 = Anuncio.builder()
                .id(1L)
                .temperaturaMaxima(25D)
                .temperaturaMinima(10D)
                .volume(0.001D)
                .preco(BigDecimal.valueOf(5.25))
                .vendedor(vendedor1)
                .produto(produto1)
                .tipo(Tipos.FRESCO)
                .build();

        Set<Anuncio> anunciosSet = new HashSet<>();
        anunciosSet.add(anuncio1);
        produto1.setAnuncios(anunciosSet);
        vendedor1.setAnuncios(anunciosSet);

        Armazem armazem1 = Armazem.builder()
                .id(1L)
                .cep("01000-001")
                .nome("CD_Guarulhos")
                .build();

        Setor setor1 = Setor.builder()
                .id(1L)
                .armazem(armazem1)
                .volume(500D)
                .nome("FRESCO")
                .build();


        OrdemEntrada ordemEntrada1 = OrdemEntrada.builder()
                .id(1L)
                .setor(setor1)
                .dataCriacao(LocalDateTime.of(2022,1,1,2,2,2))
                .build();

        Estoque estoque1 = Estoque.builder()
                .id(1L)
                .dataProducao(LocalDateTime.of(2022, 1, 1, 12, 30))
                .dataValidade(LocalDate.of(2022, 12, 1))
                .quantidadeAtual(100)
                .quantidadeInicial(100)
                .temperaturaAtual(20D)
                .anuncio(anuncio1)
                .ordemEntrada(ordemEntrada1)
                .build();

        Estoque estoque2 = Estoque.builder()
                .id(2L)
                .dataProducao(LocalDateTime.of(2022, 1, 1, 12, 30))
                .dataValidade(LocalDate.of(2022, 11, 1))
                .quantidadeAtual(50)
                .quantidadeInicial(500)
                .temperaturaAtual(20D)
                .anuncio(anuncio1)
                .ordemEntrada(ordemEntrada1)
                .build();

        Set<Estoque> estoqueSet = new HashSet<>();
        estoqueSet.add(estoque1);
        estoqueSet.add(estoque2);

        anuncio1.setEstoques(estoqueSet);

        this.anuncios.add(anuncio1);

    }
}
