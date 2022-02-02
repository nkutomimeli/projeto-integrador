package com.example.demo.service;

import com.example.demo.entity.Produto;
import com.example.demo.repository.ProdutoRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public void save(Produto produto){
        this.produtoRepository.save(produto);
    }

    public Produto findById(Long id) { return this.produtoRepository.findById(id).orElse(new Produto()); }

}
