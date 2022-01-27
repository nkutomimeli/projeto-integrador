package com.example.demo.mock;

import com.example.demo.entity.Vendedor;
import com.example.demo.repository.VendedorRepository;
import com.example.demo.service.VendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class VendedorMock {

    @Autowired
    private VendedorService vendedorService;

    public void cargaInicial(){

        Vendedor v1 = new Vendedor();
        v1.setNome("Antonio");

        Vendedor v2 = new Vendedor();
        v2.setNome("Pedro");

        Vendedor v3 = new Vendedor();
        v3.setNome("Mariana");

        Vendedor v4 = new Vendedor();
        v4.setNome("Leticia");

        Vendedor v5 = new Vendedor();
        v5.setNome("Ronaldo");

        vendedorService.save(v1);
        vendedorService.save(v2);
        vendedorService.save(v3);
        vendedorService.save(v4);
        vendedorService.save(v5);
    }

}
