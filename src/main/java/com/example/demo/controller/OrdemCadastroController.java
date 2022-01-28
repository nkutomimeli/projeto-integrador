package com.example.demo.controller;

import com.example.demo.dto.EstoqueDTO;
import com.example.demo.dto.InboundOrderDTO;
import com.example.demo.entity.*;
import com.example.demo.mock.AnuncioMock;
import com.example.demo.mock.ProdutoMock;
import com.example.demo.mock.VendedorMock;
import com.example.demo.service.OrdemEntradaService;
import com.example.demo.service.VendedorService;
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
    private VendedorMock vendedorMock;

    @Autowired
    private ProdutoMock produtoMock;

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
        //anuncioMock.cargaInicial();
    }

    @Autowired
   private OrdemEntradaService ordemEntradaService;

    @PostMapping("/inboundorder")
   public ResponseEntity<List<EstoqueDTO>> cadastraLote(@Valid @RequestBody InboundOrderDTO inboundOrderDTO) {
       List<EstoqueDTO> listaEstoque = ordemEntradaService.save(inboundOrderDTO);
       return ResponseEntity.status(HttpStatus.CREATED).body(listaEstoque);
   }

    @GetMapping("/inboundorder/{id}")
    public ResponseEntity<Setor> cadastraLote(@PathVariable Long id) {

        Setor setor = ordemEntradaService.get(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(setor);
    }

//
//    @PutMapping("/inboundorder")
//    public ResponseEntity<Estoque> atualizaEstoque(@Valid @RequestBody OrdemEntrada ordemEntrada) {
//        Estoque estoqueAtualizado = ordemEntrada.atualizar(ordemEntrada);
//        return ResponseEntity.status(HttpStatus.CREATED).body(estoqueAtualizado);
//    }
}
