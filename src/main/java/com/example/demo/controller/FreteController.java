package com.example.demo.controller;

import com.example.demo.dto.CarrinhoFreteDTO;
import com.example.demo.entity.OrdemEntrada;
import com.example.demo.service.CarrinhoFreteService;
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
    private CarrinhoFreteService carrinhoFreteService;

    @GetMapping("/frete") // ?carrinho_id
    public ResponseEntity<CarrinhoFreteDTO> CalculaFreteCarrinho (@RequestParam("carrinho_id") Long id) {
        CarrinhoFreteDTO carrinhoFreteDTO = carrinhoFreteService.getCarrinhoComFreteById(id);
        return ResponseEntity.status(HttpStatus.OK).body(carrinhoFreteDTO);
    }

    // Colocar na apresentação que foi baseado numa compra real no Mercado Livre
    // em que recebi compras separadas por causa do tipo dos produtos
    // Por isso de calcular um frete diferente baseado na categoria ("FRESCO", "REFRIGERADO",
    // "CONGELADO") e no volume do produto.

}
