package com.example.demo.controller;

import com.example.demo.dto.EstoqueDTO;
import com.example.demo.dto.InboundOrderDTO;
import com.example.demo.entity.Carrinho;
import com.example.demo.entity.OrdemEntrada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/fresh-products")
public class CarrinhoController {

//    @Autowired
//    private CarrinhoService carrinhoService;

    @PostMapping("/orders")
    public ResponseEntity<PrecoTotalDTO> criarCarrinho(@Valid @RequestBody CarrinhoDTO carrinhoDTO) {
        PrecoTotalDTO precoTotal = carrinhoService.save(carrinhoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(precoTotal);
    }

    @GetMapping("/orders/{id}")
    public ResponseEntity<CarrinhoDTO> pegarCarrinhoPorId(@PathVariable Long id) {
        CarrinhoDTO carrinho = carrinhoService.getCarrinhoById(id);
        return ResponseEntity.status(HttpStatus.OK).body(carrinho);
    }

    @PutMapping("/orders/{id}")
    public ResponseEntity<CarrinhoDTO> atualizaCarrinho(@Valid @RequestBody CarrinhoDTO carrinhoDTO, @PathVariable Long id) {
        CarrinhoDTO carrinho = carrinhoService.update(carrinhoDTO, id);
        return ResponseEntity.status(HttpStatus.CREATED).body(carrinho);
    }


}
