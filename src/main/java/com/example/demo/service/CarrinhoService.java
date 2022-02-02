package com.example.demo.service;

import com.example.demo.dto.CarrinhoDTO;
import com.example.demo.dto.ItemCarrinhoDTO;
import com.example.demo.dto.PrecoTotalDTO;
import com.example.demo.entity.Anuncio;
import com.example.demo.entity.Carrinho;
import com.example.demo.entity.Comprador;
import com.example.demo.entity.ItemCarrinho;
import com.example.demo.repository.AnuncioRepository;
import com.example.demo.repository.CarrinhoRepository;
import com.example.demo.repository.CompradorRepository;
import com.example.demo.repository.ItemCarrinhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CarrinhoService {

    @Autowired
    CarrinhoRepository carrinhoRepository;

    @Autowired
    CompradorRepository compradorRepository;

    @Autowired
    AnuncioRepository anuncioRepository;

    @Autowired
    ItemCarrinhoRepository itemCarrinhoRepository;

    public PrecoTotalDTO save(CarrinhoDTO carrinhoDTO) {


        // Salva o Carrinho no banco de dados
        Comprador comprador = this.compradorRepository.findById(carrinhoDTO.getComprador_id()).orElse(new Comprador());
        Carrinho carrinho = CarrinhoDTO.converte(carrinhoDTO, comprador);
        Carrinho carrinhoSalvo = this.carrinhoRepository.save(carrinho);

        // Salva o ItemCarrinho no banco de dados

        Set<ItemCarrinhoDTO> listaItemCarrinho = carrinhoDTO.getListaAnuncio();
        listaItemCarrinho.forEach((item -> {
            Anuncio anuncio = this.anuncioRepository.findById(item.getAnuncio_id()).orElse(new Anuncio());
            ItemCarrinho itemCarrinho = ItemCarrinhoDTO.converte(item, anuncio, carrinhoSalvo);
            this.itemCarrinhoRepository.save(itemCarrinho);
        }));

        // Instanciar precoTotalDTO e devolver pro controller
        return PrecoTotalDTO.builder()
                .precoTotal(this.itemCarrinhoRepository.totalPreco(carrinhoSalvo.getId()))
                .build();
    }

    public CarrinhoDTO getCarrinhoById(Long id) {

        Carrinho carrinho = this.carrinhoRepository.findById(id).orElse(new Carrinho());
        return CarrinhoDTO.converte(carrinho);
    }

    public CarrinhoDTO update(CarrinhoDTO carrinhoDTO, Long id) {

        // Atualiza o Carrinho no banco de dados
        Carrinho carrinho = this.carrinhoRepository.findById(id).orElse(new Carrinho());
        Carrinho carrinhoSalvo = this.carrinhoRepository.save(carrinho);

        // Atualiza o ItemCarrinho no banco de dados
        Set<ItemCarrinhoDTO> listaItemCarrinho = carrinhoDTO.getListaAnuncio();
        listaItemCarrinho.forEach((item -> {
            ItemCarrinho itemCarrinho = this.itemCarrinhoRepository.findById(item.getId()).orElse(new ItemCarrinho());
            Anuncio anuncio = this.anuncioRepository.findById(item.getAnuncio_id()).orElse(new Anuncio());
            itemCarrinho.setCarrinho(carrinhoSalvo);
            itemCarrinho.setAnuncio(anuncio);
            this.itemCarrinhoRepository.save(ItemCarrinhoDTO.converte(item, anuncio, carrinhoSalvo));
        }));
        return CarrinhoDTO.converte(carrinhoSalvo);
    }
}
