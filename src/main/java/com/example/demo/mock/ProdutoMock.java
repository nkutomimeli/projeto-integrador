package com.example.demo.mock;


import com.example.demo.entity.Produto;
import com.example.demo.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProdutoMock {

    @Autowired
    private ProdutoService produtoService;

    public void cargaInicial(){
        Produto p1 = new Produto();
        p1.setNome("Picanha 1kg");
        p1.setDescricao("Peça de picanha congelada de um quilo");

        Produto p2 = new Produto();
        p2.setNome("Iogurte Grego");
        p2.setDescricao("Iogurte de flocos tipo Grego");

        Produto p3 = new Produto();
        p3.setNome("Banana");
        p3.setDescricao("Banana fresca");

        this.produtoService.save(p1);
        this.produtoService.save(p2);
        this.produtoService.save(p3);
    }
}
