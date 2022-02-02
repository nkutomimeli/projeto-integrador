package com.example.demo.mock;

import com.example.demo.entity.Anuncio;
import com.example.demo.entity.Produto;
import com.example.demo.entity.Vendedor;
import com.example.demo.service.AnuncioService;
import com.example.demo.service.ProdutoService;
import com.example.demo.service.VendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class AnuncioMock {

    @Autowired
    private AnuncioService anuncioService;

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private VendedorService vendedorService;

    /*public void cargaInicial(){
        Produto p1 = this.produtoService.findById(1L);
        Vendedor v1 = this.vendedorService.findById(4L);

        Anuncio a1 = new Anuncio();

        a1.setPreco(new BigDecimal(350));
        a1.setTemperaturaMaxima(0.0);
        a1.setTemperaturaMinima(-25.0);
        a1.setVolume(1.0);
        a1.setProduto(p1);
        a1.setVendedor(v1);

        this.anuncioService.save(a1);

    }
   */
}
