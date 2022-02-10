package com.example.demo.utils;

import com.example.demo.dto.CarrinhoDTO;
import com.example.demo.dto.ItemCarrinhoDTO;
import com.example.demo.entity.*;
import com.example.demo.enums.Status;
import com.example.demo.enums.Tipos;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Getter
@Setter
public class MockCarrinhoFrete {

    private Carrinho carrinho;
    private List<Veiculo> veiculos = new ArrayList<>();

    public MockCarrinhoFrete() {

        Usuario usuario = Usuario.builder()
                .user("lucian")
                .senha("12345")
                .ativo(true)
                .build();

        Comprador comprador1 = Comprador.builder()
                .id(1L)
                .usuario(usuario)
                .build();

        carrinho = Carrinho.builder()
                .id(1L)
                .dataCriacao(LocalDateTime.of(2022, 2, 5, 12, 30))
                .comprador(comprador1)
                .status(0)
                .build();

        Produto produto1 = Produto.builder()
                .id(1L)
                .nome("alface")
                .descricao("verde")
                .build();

        Vendedor vendedor1 = Vendedor.builder()
                .id(1L)
                .nome("ismael")
                .build();

        Anuncio anuncio1 = Anuncio.builder()
                .id(1L)
                .produto(produto1)
                .vendedor(vendedor1)
                .preco(new BigDecimal(2))
                .volume(0.0005D)
                .temperaturaMaxima(23D)
                .temperaturaMinima(18D)
                .tipo(Tipos.FRESCO)
                .build();

        Produto produto2 = Produto.builder()
                .id(2L)
                .nome("Asas de Frango")
                .descricao("Congelado")
                .build();

        Anuncio anuncio2 = Anuncio.builder()
                .id(2L)
                .produto(produto2)
                .vendedor(vendedor1)
                .preco(new BigDecimal(15))
                .volume(0.001D)
                .temperaturaMaxima(5D)
                .temperaturaMinima(-15D)
                .tipo(Tipos.CONGELADO)
                .build();

        Produto produto3 = Produto.builder()
                .id(3L)
                .nome("Iogurte")
                .descricao("Sabor Morango")
                .build();

        Anuncio anuncio3 = Anuncio.builder()
                .id(3L)
                .produto(produto3)
                .vendedor(vendedor1)
                .preco(new BigDecimal(12))
                .volume(0.001D)
                .temperaturaMaxima(10D)
                .temperaturaMinima(-3D)
                .tipo(Tipos.REFRIGERADO)
                .build();


        ItemCarrinho itemCarrinho1 = ItemCarrinho.builder()
                .id(1L)
                .anuncio(anuncio1)
                .carrinho(carrinho)
                .quantidade(30)
                .preco(anuncio1.getPreco())
                .build();

        ItemCarrinho itemCarrinho2 = ItemCarrinho.builder()
                .id(2L)
                .anuncio(anuncio2)
                .carrinho(carrinho)
                .quantidade(10)
                .preco(anuncio2.getPreco())
                .build();

        ItemCarrinho itemCarrinho3 = ItemCarrinho.builder()
                .id(3L)
                .anuncio(anuncio3)
                .carrinho(carrinho)
                .quantidade(15)
                .preco(anuncio3.getPreco())
                .build();

        Set<ItemCarrinho> itensCarrinho = new HashSet<>();
        itensCarrinho.add(itemCarrinho1);
        itensCarrinho.add(itemCarrinho2);
        itensCarrinho.add(itemCarrinho3);

        carrinho.setItensCarrinho(itensCarrinho);

        Veiculo veiculo1 = Veiculo.builder()
                .id(1L)
                .nome("Fiorino")
                .categoria(Tipos.FRESCO)
                .volume(3345D)
                .fretePorLitro(new BigDecimal(1.30))
                .build();

        Veiculo veiculo2 = Veiculo.builder()
                .id(2L)
                .nome("Mercedes-Benz Sprinter")
                .categoria(Tipos.REFRIGERADO)
                .volume(10000D)
                .fretePorLitro(new BigDecimal(1.65))
                .build();

        Veiculo veiculo3 = Veiculo.builder()
                .id(3L)
                .nome("Hyunday HR")
                .categoria(Tipos.CONGELADO)
                .volume(10000D)
                .fretePorLitro(new BigDecimal(2.00))
                .build();

        veiculos.add(veiculo1);
        veiculos.add(veiculo2);
        veiculos.add(veiculo3);

//        ordemEntrada = OrdemEntrada.builder()
//                .id(1L)
//                .dataCriacao(LocalDateTime.of(2022,1,1,2,2,2))
//                .build();

//        estoque = Estoque.builder()
//                .id(1L)
//                .dataProducao(LocalDateTime.of(2022,1,1,2,2,2))
//                .quantidadeAtual(100)
//                .quantidadeInicial(100)
//                .anuncio(anuncio)
//                .dataValidade(LocalDate.now())
//                .ordemEntrada(ordemEntrada)
//                .build();
//
//        listaEstoque.add(estoque);
//
//        itemCarrinho = ItemCarrinhoDTO.converte(item, anuncio, carrinho);
//        itemCarrinhoUpdate = ItemCarrinhoDTO.converte(itemUpdate, anuncio, carrinho);
//
//        itensCarrinhos.add(itemCarrinho);
//        itensCarrinhosSalvo.add(itemCarrinhoUpdate);
//
//        Set<ItemCarrinho> listaAnuncioSet = new HashSet<>(itensCarrinhos);
//        Set<ItemCarrinho> listaAnuncioSetSalvo = new HashSet<>(itensCarrinhosSalvo);

//        carrinhoSalvo = Carrinho.builder()
//                .id(1L)
//                .dataCriacao(LocalDateTime.of(2022,1,1,2,2,2))
//                .status(0)
//                .comprador(comprador)
//                .itensCarrinho(listaAnuncioSetSalvo)
//                .build();
//
//        dto = CarrinhoDTO.builder()
//                .dataCriacao(LocalDateTime.of(2022,1,1,2,2,2))
//                .comprador_id(1L)
//                .status(Status.ABERTO)
//                .listaAnuncio(listaAnuncio)
//                .build();
//
//
//        dtoUpdate = CarrinhoDTO.builder()
//                .dataCriacao(LocalDateTime.of(2022,1,1,2,2,2))
//                .comprador_id(1L)
//                .status(Status.ABERTO)
//                .listaAnuncio(listaAnuncioUpdate)
//                .build();
    }
}
