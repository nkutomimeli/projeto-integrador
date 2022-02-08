package com.example.demo.utils;

import com.example.demo.dto.CarrinhoDTO;
import com.example.demo.dto.ItemCarrinhoDTO;
import com.example.demo.entity.*;
import com.example.demo.enums.Status;
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
public class mockCarrinho {

    private Set<ItemCarrinhoDTO> listaAnuncio = new HashSet<>();
    private List<Estoque> listaEstoque = new ArrayList<>();
    private OrdemEntrada ordemEntrada = new OrdemEntrada();
    private Produto produto = new Produto();
    private Vendedor vendedor = new Vendedor();
    private Anuncio anuncio = new Anuncio();
    private Estoque estoque = new Estoque();
    private Usuario usuario = new Usuario();
    private Comprador comprador = new Comprador();
    private Carrinho carrinho = new Carrinho();
    private CarrinhoDTO dto = new CarrinhoDTO();
    private ItemCarrinho itemCarrinho = new ItemCarrinho();
    private List<ItemCarrinho> itensCarrinhos = new ArrayList<>();

    public MockCarrinhoObjeto() {

        ItemCarrinhoDTO item = ItemCarrinhoDTO.builder()
                .anuncio_id(1L)
                .quantidade(1)
                .build();

        listaAnuncio.add(item);

        ordemEntrada = OrdemEntrada.builder()
                .id(1L)
                .dataCriacao(LocalDateTime.of(2022,1,1,2,2,2))
                .build();

        produto = Produto.builder()
                .id(1L)
                .nome("alface")
                .descricao("verde")
                .build();

        vendedor = Vendedor.builder()
                .id(1L)
                .nome("ismael")
                .build();

        anuncio = Anuncio.builder()
                .id(1L)
                .produto(produto)
                .vendedor(vendedor)
                .preco(new BigDecimal(2))
                .volume(1d)
                .temperaturaMaxima(25d)
                .temperaturaMinima(18d)
                .tipo(Tipos.FRESCO)
                .build();

        estoque = Estoque.builder()
                .id(1L)
                .dataProducao(LocalDateTime.of(2022,1,1,2,2,2))
                .quantidadeAtual(100)
                .quantidadeInicial(100)
                .anuncio(anuncio)
                .dataValidade(LocalDate.now())
                .ordemEntrada(ordemEntrada)
                .build();

        listaEstoque.add(estoque);

        usuario = Usuario.builder()
                .user("lucian")
                .senha("12345")
                .ativo(true)
                .build();

        comprador = Comprador.builder()
                .id(1L)
                .usuario(usuario)
                .build();

        carrinho = Carrinho.builder()
                .id(1L)
                .dataCriacao(LocalDateTime.of(2022,1,1,2,2,2))
                .status(0)
                .comprador(comprador)
                .build();

        dto = CarrinhoDTO.builder()
                .dataCriacao(LocalDateTime.of(2022,1,1,2,2,2))
                .comprador_id(1L)
                .status(Status.ABERTO)
                .listaAnuncio(listaAnuncio)
                .build();

        itemCarrinho = ItemCarrinhoDTO.converte(item, anuncio, carrinho);

        itensCarrinhos.add(itemCarrinho);


    }
}
