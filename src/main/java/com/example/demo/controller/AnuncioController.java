package com.example.demo.controller;

import com.example.demo.entity.Anuncio;
import com.example.demo.entity.OrdemEntrada;
import com.example.demo.enums.Tipos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/fresh-products")
public class AnuncioController {

//    @Autowired
//    private AnuncioService anuncioService;

    @GetMapping("")
    public ResponseEntity<List<Anuncio>> listProdutos() {
//        List<Anuncio> listaAnuncios = anuncioService.listProdutos();
//        return ResponseEntity.status(HttpStatus.OK).body(listaAnuncios);
        return null;
    }

    @GetMapping("/list") // ?querytype=F
    public ResponseEntity<OrdemEntrada> getEstoque(@RequestParam("querytype") Tipos categoria) {
        System.out.println(categoria);
//        List<Anuncio> listaAnuncios = anuncioService.listProdutosByCategory(categoria);
//        return ResponseEntity.status(HttpStatus.OK).body(listaAnuncios);
        return null;
    }

}
