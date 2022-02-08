package com.example.demo.service;

import com.example.demo.entity.Vendedor;
import com.example.demo.repository.VendedorRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Service
public class VendedorService {

    @Autowired
    private VendedorRepository vendedorRepository;

    public void save(Vendedor vendedor){
        this.vendedorRepository.save(vendedor);
    }

}
