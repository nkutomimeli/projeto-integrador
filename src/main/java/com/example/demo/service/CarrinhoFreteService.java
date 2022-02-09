package com.example.demo.service;

import com.example.demo.dto.CarrinhoFreteDTO;
import com.example.demo.entity.Carrinho;
import com.example.demo.exception.CarrinhoInexistenteException;
import com.example.demo.repository.CarrinhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarrinhoFreteService {

    @Autowired
    private CarrinhoRepository carrinhoRepository;

    @Autowired
    private CarrinhoService carrinhoService;

    public CarrinhoFreteService(CarrinhoRepository carrinhoRepository, CarrinhoService carrinhoService) {
        this.carrinhoRepository = carrinhoRepository;
        this.carrinhoService = carrinhoService;
    }

    public CarrinhoFreteDTO getCarrinhoComFreteById(Long id) {
        Optional<Carrinho> carrinhoOptional = carrinhoRepository.findById(id);
        if (carrinhoOptional.isEmpty())
            throw new CarrinhoInexistenteException("Não foi encontrado carrinho com este ID.")
    }
}
