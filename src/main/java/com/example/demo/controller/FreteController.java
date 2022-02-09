package com.example.demo.controller;

import com.example.demo.entity.OrdemEntrada;
import com.example.demo.service.CarrinhoService;
import com.example.demo.service.OrdemEntradaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/fresh-products")
public class FreteController {

    @Autowired
    private CarrinhoService carrinhoService;

    @GetMapping("/frete") // ?carrinho_id
    public ResponseEntity<CarrinhoFreteDTO> CalculaFreteCarrinho (@RequestParam("carrinho_id") Long id) {
        CarrinhoFreteDTO carrinhoFreteDTO = carrinhoService.getCarrinhoComFreteById(id);
        return ResponseEntity.status(HttpStatus.OK).body(carrinhoFreteDTO);
    }

}
