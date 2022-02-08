package com.example.demo.serviceTest;

import com.example.demo.entity.*;
import com.example.demo.service.AnuncioService;
import com.example.demo.service.EstoqueService;
import com.example.demo.service.OrdemEntradaService;
import com.example.demo.service.ProdutoService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

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
                        .nome("Alface")
                        .descricao("Folhas")
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
                .
        )

        List<Estoque> listaEstoque = new ArrayList<>();
        listaEstoque.add(
                Estoque.builder()
                        .id(1L)
                        .anuncio()
                        .ordemEntrada()
                        .quantidadeInicial(e.getQuantidadeInicial())
                        .quantidadeAtual(e.getQuantidadeAtual())
                        .temperaturaAtual(e.getTemperaturaAtual())
                        .dataValidade(e.getDataValidade())
                        .dataProducao(e.getDataProducao())
                        .build();
        )

        // Estoque tem anuncio_id e ordem_entrada_id
        // Anuncio tem produto_id e vendedor_id
        // Ordem Entrada tem setor_id
        // Setor tem armazem_id

    }
}
