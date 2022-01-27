package com.example.demo.controller;

import com.example.demo.entity.OrdemEntrada;
import com.example.demo.entity.Estoque;
import com.example.demo.entity.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/fresh-products")
public class OrdemCadastroController {

//    @Autowired
//    private OrdemEntradaService ordemEntradaService;
//
//    @PostMapping("/inboundorder")
//    public ResponseEntity<List<Produto>> cadastraLote(@Valid @RequestBody OrdemEntrada ordemEntrada) {
//        List<Produto> listaProduto = ordemEntrada.salvar(ordemEntrada);
//        return ResponseEntity.status(HttpStatus.CREATED).body(listaProduto);
//    }
//
//    @PutMapping("/inboundorder")
//    public ResponseEntity<Estoque> atualizaEstoque(@Valid @RequestBody OrdemEntrada ordemEntrada) {
//        Estoque estoqueAtualizado = ordemEntrada.atualizar(ordemEntrada);
//        return ResponseEntity.status(HttpStatus.CREATED).body(estoqueAtualizado);
//    }
}
