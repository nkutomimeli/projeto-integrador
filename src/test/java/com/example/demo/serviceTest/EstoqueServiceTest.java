package com.example.demo.serviceTest;

import com.example.demo.dto.EstoqueDTO;
import com.example.demo.dto.EstoqueSetorIdDataValidadeDTO;
import com.example.demo.entity.*;
import com.example.demo.enums.Tipos;
import com.example.demo.repository.EstoqueRepository;
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


        // ANUNCIO
        // ANUNCIO 1
        // id = 1;  preco = 1.50; volume = 0.3; tipo = FRESCO; produto = 1; vendedor = 1
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
        // ANUNCIO 2
        // id = 2;  preco = 30; volume = 0.5; tipo = CONGELADO; produto = 3; vendedor = 1
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

        List<Setor> listaSetor = new ArrayList<>();
        listaSetor.add(
                Setor.builder()
                        .id(1L)
                        .nome(Tipos.CONGELADO.getDescricao())
                        .volume(150.0)
                        .build()
        );
        listaSetor.add(
                Setor.builder()
                        .id(2L)
                        .nome(Tipos.REFRIGERADO.getDescricao())
                        .volume(200.0)
                        .build()
        );
        listaSetor.add(
                Setor.builder()
                        .id(3L)
                        .nome(Tipos.FRESCO.getDescricao())
                        .volume(300.0)
                        .build()
        );

        List<OrdemEntrada> listaOrdemEntrada = new ArrayList<>();
        listaOrdemEntrada.add(
                OrdemEntrada.builder()
                        .id(1L)
                        .dataCriacao(LocalDateTime.of(2022, Month.JANUARY,13,15,15,1))
                        .setor(listaSetor.get(0))
                        .build()
        );
        listaOrdemEntrada.add(
                OrdemEntrada.builder()
                        .id(2L)
                        .dataCriacao(LocalDateTime.of(2022, Month.FEBRUARY,5,10,10,1))
                        .setor(listaSetor.get(2))
                        .build()
        );

        List<Estoque> listaEstoque = new ArrayList<>();

        listaEstoque.add(
                Estoque.builder()
                        .id(1L)
                        .anuncio(listaAnuncio.get(0))
                        .ordemEntrada(listaOrdemEntrada.get(1))
                        .quantidadeInicial(100)
                        .quantidadeAtual(100)
                        .temperaturaAtual(8.0)
                        .dataValidade(LocalDate.of(2022, 2,28))
                        .dataProducao(LocalDateTime.of(2022, Month.JANUARY, 10,8,40))
                        .build()
        );

        listaEstoque.add(
                Estoque.builder()
                        .id(1L)
                        .anuncio(listaAnuncio.get(1))
                        .ordemEntrada(listaOrdemEntrada.get(0))
                        .quantidadeInicial(150)
                        .quantidadeAtual(150)
                        .temperaturaAtual(-12.0)
                        .dataValidade(LocalDate.of(2022, 3,28))
                        .dataProducao(LocalDateTime.of(2022, Month.FEBRUARY, 23,11,40))
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

        LocalDate dataValidade =  LocalDate.now().plusDays(1);

        List<Estoque> listaEstoqueDTO = new ArrayList<>();
        for(Estoque e: listaEstoque) {
           if((e.getDataValidade().isAfter(dataValidade) || e.getDataValidade().equals(dataValidade) ) && e.getOrdemEntrada().getSetor().getId() == 3){
               listaEstoqueDTO.add(e);
               System.out.println("\n\n ESTOQUE ID: " + e.getId());
           }
        }
        EstoqueRepository estoqueRepository = Mockito.mock(EstoqueRepository.class);
        Mockito.when(estoqueRepository.getAnunciosBySetorValidadeRep(1L, 1L, dataValidade)).thenReturn(listaEstoqueDTO);

        EstoqueService estoqueService = new EstoqueService(estoqueRepository);
        estoqueService.getAllEstoqueBySetorIdDataValidade(1L, 21L);
        EstoqueSetorIdDataValidadeDTO dto = EstoqueSetorIdDataValidadeDTO.converte(listaEstoque.get(0));
        EstoqueSetorIdDataValidadeDTO dto2 = EstoqueSetorIdDataValidadeDTO.converte(listaEstoqueDTO.get(0));
        assert(dto2.equals(dto));
    }

    @Test
    public void deveRetornarTodosEstoquesPorCategoriaEDataValidade(){
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


        // ANUNCIO
        // ANUNCIO 1
        // id = 1;  preco = 1.50; volume = 0.3; tipo = FRESCO; produto = 1; vendedor = 1
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
        // ANUNCIO 2
        // id = 2;  preco = 30; volume = 0.5; tipo = CONGELADO; produto = 3; vendedor = 1
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

        List<Setor> listaSetor = new ArrayList<>();
        listaSetor.add(
                Setor.builder()
                        .id(1L)
                        .nome(Tipos.CONGELADO.getDescricao())
                        .volume(150.0)
                        .build()
        );
        listaSetor.add(
                Setor.builder()
                        .id(2L)
                        .nome(Tipos.REFRIGERADO.getDescricao())
                        .volume(200.0)
                        .build()
        );
        listaSetor.add(
                Setor.builder()
                        .id(3L)
                        .nome(Tipos.FRESCO.getDescricao())
                        .volume(300.0)
                        .build()
        );

        List<OrdemEntrada> listaOrdemEntrada = new ArrayList<>();
        listaOrdemEntrada.add(
                OrdemEntrada.builder()
                        .id(1L)
                        .dataCriacao(LocalDateTime.of(2022, Month.JANUARY,13,15,15,1))
                        .setor(listaSetor.get(0))
                        .build()
        );
        listaOrdemEntrada.add(
                OrdemEntrada.builder()
                        .id(2L)
                        .dataCriacao(LocalDateTime.of(2022, Month.FEBRUARY,5,10,10,1))
                        .setor(listaSetor.get(2))
                        .build()
        );

        List<Estoque> listaEstoque = new ArrayList<>();

        listaEstoque.add(
                Estoque.builder()
                        .id(1L)
                        .anuncio(listaAnuncio.get(0))
                        .ordemEntrada(listaOrdemEntrada.get(1))
                        .quantidadeInicial(100)
                        .quantidadeAtual(100)
                        .temperaturaAtual(8.0)
                        .dataValidade(LocalDate.of(2022, 2,28))
                        .dataProducao(LocalDateTime.of(2022, Month.JANUARY, 10,8,40))
                        .build()
        );

        listaEstoque.add(
                Estoque.builder()
                        .id(1L)
                        .anuncio(listaAnuncio.get(1))
                        .ordemEntrada(listaOrdemEntrada.get(0))
                        .quantidadeInicial(150)
                        .quantidadeAtual(150)
                        .temperaturaAtual(-12.0)
                        .dataValidade(LocalDate.of(2022, 3,28))
                        .dataProducao(LocalDateTime.of(2022, Month.FEBRUARY, 23,11,40))
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

        LocalDate dataValidade =  LocalDate.now().plusDays(1);

        List<Estoque> listaEstoqueDTO = new ArrayList<>();
        for(Estoque e: listaEstoque) {
            if((e.getDataValidade().isAfter(dataValidade) || e.getDataValidade().equals(dataValidade) ) && e.getAnuncio().getTipo().getDescricao().equals(Tipos.CONGELADO.getDescricao())){
                listaEstoqueDTO.add(e);
                System.out.println("\n\n ESTOQUE ID: " + e.getId());
            }
        }

        EstoqueRepository estoqueRepository = Mockito.mock(EstoqueRepository.class);
        Mockito.when(estoqueRepository.getAnunciosBySetorValidadeRep(1L, 1L, dataValidade)).thenReturn(listaEstoqueDTO);

        EstoqueService estoqueService = new EstoqueService(estoqueRepository);
        estoqueService.getEstoqueByDataValidadeCategoria(1L, 2, "asc");
        EstoqueSetorIdDataValidadeDTO dto = EstoqueSetorIdDataValidadeDTO.converte(listaEstoque.get(1));
        EstoqueSetorIdDataValidadeDTO dto2 = EstoqueSetorIdDataValidadeDTO.converte(listaEstoqueDTO.get(0));
        assert(dto2.equals(dto));
    }
}
