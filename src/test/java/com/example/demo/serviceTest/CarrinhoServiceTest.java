package com.example.demo.serviceTest;

import com.example.demo.dto.CarrinhoDTO;
import com.example.demo.dto.ItemCarrinhoDTO;
import com.example.demo.dto.PrecoTotalDTO;
import com.example.demo.entity.*;
import com.example.demo.enums.Status;
import com.example.demo.enums.Tipos;
import com.example.demo.repository.*;
import com.example.demo.service.CarrinhoService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class CarrinhoServiceTest {

    @Test
    public void deveSalvarUmCarrinho() {

        Set<ItemCarrinhoDTO> listaAnuncio = new HashSet<>();
        List<Estoque> listaEstoque = new ArrayList<>();

        ItemCarrinhoDTO item = ItemCarrinhoDTO.builder()
                .anuncio_id(1L)
                .quantidade(1)
                .build();

        listaAnuncio.add(item);

        OrdemEntrada ordemEntrada = OrdemEntrada.builder()
                .id(1L)
                .dataCriacao(LocalDateTime.of(2022,1,1,2,2,2))
                .build();

        Produto produto = Produto.builder()
                .id(1L)
                .nome("alface")
                .descricao("verde")
                .build();

        Vendedor vendedor = Vendedor.builder()
                .id(1L)
                .nome("ismael")
                .build();

        Anuncio anuncio = Anuncio.builder()
                .id(1L)
                .produto(produto)
                .vendedor(vendedor)
                .preco(new BigDecimal(2))
                .volume(1d)
                .temperaturaMaxima(25d)
                .temperaturaMinima(18d)
                .tipo(Tipos.FRESCO)
                .build();

        Estoque estoque = Estoque.builder()
                .id(1L)
                .dataProducao(LocalDateTime.of(2022,1,1,2,2,2))
                .quantidadeAtual(100)
                .quantidadeInicial(100)
                .anuncio(anuncio)
                .dataValidade(LocalDate.now())
                .ordemEntrada(ordemEntrada)
                .build();

        listaEstoque.add(estoque);

        Usuario usuario = Usuario.builder()
                .user("lucian")
                .senha("12345")
                .ativo(true)
                .build();

        Comprador comprador = Comprador.builder()
                .id(1L)
                .usuario(usuario)
                .build();


        Carrinho carrinho = Carrinho.builder()
                .id(1L)
                .dataCriacao(LocalDateTime.of(2022,1,1,2,2,2))
                .status(0)
                .comprador(comprador)
                .build();

        CarrinhoDTO dto = CarrinhoDTO.builder()
                .dataCriacao(LocalDateTime.of(2022,1,1,2,2,2))
                .comprador_id(1L)
                .status(Status.ABERTO)
                .listaAnuncio(listaAnuncio)
                .build();

        ItemCarrinho itemCarrinho = ItemCarrinhoDTO.converte(item, anuncio, carrinho);
        List<ItemCarrinho> itensCarrinhos = new ArrayList<>();
        itensCarrinhos.add(itemCarrinho);

        // Simular comportamento da query precoTotal em ItemCarrinhoRepository
        List<Double> listaPrecos = new ArrayList<>();

        for (ItemCarrinho i : itensCarrinhos) {
            Double preco = i.getPreco().doubleValue() * i.getQuantidade();
            listaPrecos.add(preco);
        }

        Double totalPreco = listaPrecos.stream().reduce(0d,Double::sum);


        CarrinhoRepository mockCarrinho = Mockito.mock(CarrinhoRepository.class);
        AnuncioRepository mockAnuncio = Mockito.mock(AnuncioRepository.class);
        CompradorRepository mockComprador = Mockito.mock(CompradorRepository.class);
        EstoqueRepository mockEstoque = Mockito.mock(EstoqueRepository.class);
        ItemCarrinhoRepository mockItemCarrinho = Mockito.mock(ItemCarrinhoRepository.class);

        Mockito.when(mockCarrinho.save(Mockito.any(Carrinho.class))).thenReturn(carrinho);
        Mockito.when(mockComprador.save(comprador)).thenReturn(comprador);
        Mockito.when(mockComprador.save(comprador)).thenReturn(comprador);
        Mockito.when(mockComprador.findById(comprador.getId())).thenReturn(Optional.of(comprador));
        Mockito.when(mockItemCarrinho.save(itemCarrinho)).thenReturn(itemCarrinho);
        Mockito.when(mockEstoque.findAllAnuncio(item.getAnuncio_id())).thenReturn(listaEstoque);
        Mockito.when(mockAnuncio.findById(item.getAnuncio_id())).thenReturn(Optional.of(anuncio));
        Mockito.when(mockItemCarrinho.totalPreco(carrinho.getId())).thenReturn(totalPreco);

        CarrinhoService carrinhoService = new CarrinhoService(mockCarrinho, mockAnuncio, mockComprador, mockEstoque, mockItemCarrinho);
        PrecoTotalDTO precoTotalDTO = carrinhoService.save(dto);

        assertEquals(precoTotalDTO.getPrecoTotal(), 2);
    }
}
