package com.example.demo.serviceTest;

import com.example.demo.dto.AnuncioExternoDTO;
import com.example.demo.dto.CarrinhoFreteDTO;
import com.example.demo.entity.Anuncio;
import com.example.demo.entity.Carrinho;
import com.example.demo.entity.Veiculo;
import com.example.demo.enums.Tipos;
import com.example.demo.repository.AnuncioRepository;
import com.example.demo.repository.CarrinhoRepository;
import com.example.demo.repository.ItemCarrinhoRepository;
import com.example.demo.repository.VeiculoRepository;
import com.example.demo.service.AnuncioService;
import com.example.demo.service.CarrinhoFreteService;
import com.example.demo.utils.MockAnuncios;
import com.example.demo.utils.MockCarrinhoFrete;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CarrinhoFreteServiceTest {

    private MockCarrinhoFrete mockCarrinhoFrete;
    private Carrinho carrinho;
    private List<Veiculo> veiculos;
    private CarrinhoRepository carrinhoRepoMock;
    private ItemCarrinhoRepository itemCarrinhoRepoMock;
    private VeiculoRepository veiculoRepoMock;

    @BeforeEach
    void init() {
        mockCarrinhoFrete = new MockCarrinhoFrete();
        carrinho = mockCarrinhoFrete.getCarrinho();
        veiculos = mockCarrinhoFrete.getVeiculos();
        carrinhoRepoMock = Mockito.mock(CarrinhoRepository.class);
        itemCarrinhoRepoMock = Mockito.mock(ItemCarrinhoRepository.class);
        veiculoRepoMock = Mockito.mock(VeiculoRepository.class);
    }


    @Test
    public void deveRetornarUmDTOComValorDoFrete() {
        //arrange

        Mockito.when(carrinhoRepoMock.findById(1L)).thenReturn(Optional.of(carrinho));
        Mockito.when(itemCarrinhoRepoMock.totalPreco(1L)).thenReturn(390D);
        Mockito.when(veiculoRepoMock.findByCategoria(Tipos.FRESCO)).thenReturn(veiculos.get(0));
        Mockito.when(veiculoRepoMock.findByCategoria(Tipos.REFRIGERADO)).thenReturn(veiculos.get(1));
        Mockito.when(veiculoRepoMock.findByCategoria(Tipos.CONGELADO)).thenReturn(veiculos.get(2));

        CarrinhoFreteService carrinhoFreteService = new CarrinhoFreteService(carrinhoRepoMock, itemCarrinhoRepoMock, veiculoRepoMock);

        //act
        CarrinhoFreteDTO carrinhoFreteDTOObtido = carrinhoFreteService.getCarrinhoComFreteById(1L);

        //assert
        assertTrue(carrinhoFreteDTOObtido.getPreco().getFrete().equals(new BigDecimal(64.25D)));
    }

}

