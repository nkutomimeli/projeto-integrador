package com.example.demo.service;

import com.example.demo.dto.CarrinhoFreteDTO;
import com.example.demo.dto.PrecoDTO;
import com.example.demo.entity.Carrinho;
import com.example.demo.entity.ItemCarrinho;
import com.example.demo.entity.Veiculo;
import com.example.demo.enums.Tipos;
import com.example.demo.exception.CarrinhoInexistenteException;
import com.example.demo.exception.ItensCarrinhoVazioException;
import com.example.demo.repository.CarrinhoRepository;
import com.example.demo.repository.ItemCarrinhoRepository;
import com.example.demo.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Optional;
import java.util.Set;

@Service
public class CarrinhoFreteService {

    @Autowired
    private CarrinhoRepository carrinhoRepository;

    @Autowired
    private ItemCarrinhoRepository itemCarrinhoRepository;

    @Autowired
    private VeiculoRepository veiculoRepository;

    public CarrinhoFreteService(CarrinhoRepository carrinhoRepository, ItemCarrinhoRepository itemCarrinhoRepository, VeiculoRepository veiculoRepository) {
        this.carrinhoRepository = carrinhoRepository;
        this.itemCarrinhoRepository = itemCarrinhoRepository;
        this.veiculoRepository = veiculoRepository;
    }

    public CarrinhoFreteDTO getCarrinhoComFreteById(Long id) {
        Optional<Carrinho> carrinhoOptional = carrinhoRepository.findById(id);
        if (carrinhoOptional.isEmpty()) throw new CarrinhoInexistenteException("Não foi encontrado carrinho com este ID.");
        Carrinho carrinho = carrinhoOptional.get();

        CarrinhoFreteDTO carrinhoFreteDTO = getCarrinhoComFreteDTO(carrinho);

        return carrinhoFreteDTO;
    }

    private CarrinhoFreteDTO getCarrinhoComFreteDTO(Carrinho carrinho) {
        BigDecimal subtotal = new BigDecimal(itemCarrinhoRepository.totalPreco(carrinho.getId()));
        BigDecimal frete = calculaFrete(carrinho);
        BigDecimal total = subtotal.add(frete);

        PrecoDTO precoDTO = PrecoDTO.builder()
                .subtotal(subtotal)
                .frete(frete)
                .total(total)
                .build();

        CarrinhoFreteDTO carrinhoFreteDTO = CarrinhoFreteDTO.builder()
                .id(carrinho.getId())
                .comprador(carrinho.getComprador().getId())
                .status(carrinho.getStatus())
                .preco(precoDTO)
                .build();

        return carrinhoFreteDTO;
    }

    private BigDecimal calculaFrete(Carrinho carrinho) {

        HashMap fretes = new HashMap<Tipos, BigDecimal>();
        for (Tipos tipo: Tipos.values()) {
            Veiculo veiculo = veiculoRepository.findByCategoria(tipo);
            fretes.put(tipo, veiculo.getFretePorLitro());
        }

        Set<ItemCarrinho> itensCarrinho = carrinho.getItensCarrinho();
        if (itensCarrinho.isEmpty()) throw new ItensCarrinhoVazioException("Carrinho sem itens!");

        BigDecimal freteTotal = new BigDecimal(0);
        for (ItemCarrinho itemCarrinho : itensCarrinho) {
            Tipos categoria = itemCarrinho.getAnuncio().getTipo();
            BigDecimal fretePorLitro = (BigDecimal) fretes.get(categoria);
            double volumeLitro = itemCarrinho.getAnuncio().getVolume() * 1000;
            Integer quantidade = itemCarrinho.getQuantidade();
            freteTotal = freteTotal.add(fretePorLitro.multiply(BigDecimal.valueOf(quantidade * volumeLitro)));
        }
        return freteTotal.setScale(2, RoundingMode.HALF_UP);
    }
}
