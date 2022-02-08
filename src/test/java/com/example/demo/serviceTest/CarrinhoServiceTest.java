package com.example.demo.serviceTest;

import com.example.demo.dto.CarrinhoDTO;
import com.example.demo.dto.ItemCarrinhoDTO;
import com.example.demo.dto.PrecoTotalDTO;
import com.example.demo.entity.*;
import com.example.demo.enums.Status;
import com.example.demo.enums.Tipos;
import com.example.demo.repository.*;
import com.example.demo.service.CarrinhoService;
import com.example.demo.utils.MockCarrinho;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

public class CarrinhoServiceTest {

    private MockCarrinho mockCarrinho;
    private Carrinho carrinho;
    private List<ItemCarrinho> itensCarrinhos;
    private Comprador comprador;
    private ItemCarrinho itemCarrinho;
    private List<Estoque> listaEstoque;
    private ItemCarrinhoDTO item;
    private Anuncio anuncio;
    private CarrinhoDTO dto;

    @BeforeEach
    void init() {

        mockCarrinho = new MockCarrinho();
        carrinho = mockCarrinho.getCarrinho();
        itensCarrinhos = mockCarrinho.getItensCarrinhos();
        comprador = mockCarrinho.getComprador();
        itemCarrinho = mockCarrinho.getItemCarrinho();
        listaEstoque = mockCarrinho.getListaEstoque();
        item = mockCarrinho.getItem();
        anuncio = mockCarrinho.getAnuncio();
        dto = mockCarrinho.getDto();
    }

    @Test
    public void deveSalvarUmCarrinho() {

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
