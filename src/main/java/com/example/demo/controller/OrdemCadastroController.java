package com.example.demo.controller;

import com.example.demo.entity.OrdemEntrada;
import com.example.demo.entity.Estoque;
import com.example.demo.entity.Produto;
import com.example.demo.entity.Vendedor;
import com.example.demo.mock.AnuncioMock;
import com.example.demo.mock.ProdutoMock;
import com.example.demo.mock.VendedorMock;
import com.example.demo.service.ProdutoService;
import com.example.demo.service.VendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.flyway.FlywayDataSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/fresh-products")
public class OrdemCadastroController {

    @Autowired
    private VendedorMock vendedorMock;

    @Autowired
    private ProdutoMock produtoMock;

    @Autowired
    private VendedorService vendedorService;

    @Autowired
    private AnuncioMock anuncioMock;

    @GetMapping("/cargaVendedor")
    public void cargaVendedor() {
        vendedorMock.cargaInicial();
    }

    @GetMapping("/cargaProduto")
    public void cargaProduto() {
        produtoMock.cargaInicial();
    }

    @GetMapping("/cargaAnuncio")
    public void cargaAnuncio() {
        anuncioMock.cargaInicial();
    }

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
