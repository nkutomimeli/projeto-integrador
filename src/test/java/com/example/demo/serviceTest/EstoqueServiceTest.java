package com.example.demo.serviceTest;

import com.example.demo.entity.*;
import com.example.demo.enums.Tipos;
import com.example.demo.service.AnuncioService;
import com.example.demo.service.EstoqueService;
import com.example.demo.service.OrdemEntradaService;
import com.example.demo.service.ProdutoService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.image.AreaAveragingScaleFilter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EstoqueServiceTest {

    @Test
    public void deveRetornarTodosEstoquesPorSetorIdEDataValidade(){
        List<Produto> listaProduto = new ArrayList<>();
        listaProduto.add(
                Produto.builder()
                .id(1L)
                .nome("Maçã")
                .descricao("Fruta")
                .build()
        );

        listaProduto.add(
                Produto.builder()
                        .id(2L)
                        .nome("Iogurte")
                        .descricao("Laticínio")
                        .build()
        );

        listaProduto.add(
                Produto.builder()
                        .id(3L)
                        .nome("Açaí")
                        .descricao("Fruta congelada")
                        .build()
        );

        List<Vendedor> listaVendedor = new ArrayList<>();
        listaVendedor.add(
            Vendedor.builder()
                .id(1L)
                .nome("Ronaldo")
                .build()
        );

        listaVendedor.add(
            Vendedor.builder()
                .id(2L)
                .nome("Jessica")
                .build()
        );

        List<Anuncio> listaAnuncio = new ArrayList<>();
        listaAnuncio.add(
                Anuncio.builder()
                .id(1L)
                .preco(new BigDecimal(1.50))
                .volume(0.3)
                .temperaturaMaxima(5.0)
                .temperaturaMinima(0.0)
                .tipo(Tipos.FRESCO)
                .produto(listaProduto.get(0))
                .vendedor(listaVendedor.get(0))
                .build()
        );

        listaAnuncio.add(
                Anuncio.builder()
                        .id(2L)
                        .preco(new BigDecimal(30.0))
                        .volume(0.5)
                        .temperaturaMaxima(-1.0)
                        .temperaturaMinima(-10.0)
                        .tipo(Tipos.CONGELADO)
                        .produto(listaProduto.get(2))
                        .vendedor(listaVendedor.get(0))
                        .build()
        );



        List<Estoque> listaEstoque = new ArrayList<>();

        listaEstoque.add(
                Estoque.builder()
                        .id(1L)
                        .anuncio(listaAnuncio.get(0))
                        //.ordemEntrada()
                        .quantidadeInicial(100)
                        .quantidadeAtual(100)
                        .temperaturaAtual(8.0)
                        .dataValidade(LocalDate.of(2022, 12,25))
                        .dataProducao(LocalDateTime.of(2022, Month.JANUARY, 10,30,40))
                        .build()
        );

        List<Representante> listaRepresentante = new ArrayList<>();
        listaRepresentante.add(
                Representante.builder()
                .id(1L)
                .nome("Antonio")
                .build()
        );

        List<Armazem> listaArmazem = new ArrayList<>();
        listaArmazem.add(
                Armazem.builder()
                .id(1L)
                .nome("CD - Sao Paulo")
                .cep("01545-050")
                .build()
        );
        listaArmazem.add(
                Armazem.builder()
                        .id(2L)
                        .nome("CD - Santa Catharina")
                        .cep("01330-010")
                        .build()
        );

        List<Setor> listaSetor = new ArrayList<>();



        List<OrdemEntrada> listaOrdemEntrada = new ArrayList<>();
        listaOrdemEntrada.add(
            OrdemEntrada.builder()
            .id(1L)
            .dataCriacao(new LocalDateTime(new LocalDate(2022,1,13),15,15))

        );



        // Estoque tem anuncio_id e ordem_entrada_id
        // Anuncio tem produto_id e vendedor_id
        // Ordem Entrada tem setor_id
        // Setor tem armazem_id

    }
}
