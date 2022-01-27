package com.example.demo.controller;

import com.example.demo.entity.OrdemCadastro;
import com.example.demo.entity.Produto;
import com.example.demo.entity.Estoque;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/fresh-products")
public class OrdemCadastroController {

    @Autowired
    private OrdemCadastroService ordemCadastro;

    @PostMapping("/inboundorder")
    public ResponseEntity<List<Produto>> cadastraLote(@Valid @RequestBody OrdemCadastro ordemCadastro) {
        List<Produto> listaProduto =  ordemCadastro.salvar(ordemCadastro);
        return ResponseEntity.status(HttpStatus.CREATED).body(listaProduto);
    }

    @PutMapping("/inboundorder")
    public ResponseEntity<Estoque> atualizaEstoque(@Valid @RequestBody OrdemCadastro ordemCadastro) {
        Estoque estoqueAtualizado = ordemCadastro.atualizar(ordemCadastro);
        return ResponseEntity.status(HttpStatus.CREATED).body(estoqueAtualizado);
    }
}
