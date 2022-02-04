package com.example.demo.controller;

import com.example.demo.dto.ArmazemDTO;
import com.example.demo.dto.ListaArmazemDTO;
import com.example.demo.entity.Armazem;
import com.example.demo.entity.Estoque;
import com.example.demo.service.ArmazemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/fresh-products")
public class ArmazemController {

    @Autowired
    private ArmazemService armazemService;

    /*
    @GetMapping("/warehouse/{produto_id}")
    public ResponseEntity<ArmazemDTO> estoquePorArmazem(@PathVariable Long produto_id) {
        ArmazemDTO estoqueArmazem = armazemService.estoquePorArmazem(produto_id);
        return ResponseEntity.status(HttpStatus.OK).body(estoqueArmazem );
    }
*/

    @GetMapping("/warehouse/{produto_id}")
    public ResponseEntity<List<ListaArmazemDTO>> estoquePorArmazem(@PathVariable Long produto_id) {
        List<ListaArmazemDTO> estoques = armazemService.estoquePorArmazem(produto_id);
        return ResponseEntity.status(HttpStatus.OK).body(estoques);
    }

}
