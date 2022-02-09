package com.example.demo.service;

import com.example.demo.entity.Vendedor;
import com.example.demo.repository.VendedorRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class VendedorService {

    @Autowired
    private VendedorRepository vendedorRepository;

    public Vendedor save(Vendedor vendedor){
        return this.vendedorRepository.save(vendedor);
    }

}
