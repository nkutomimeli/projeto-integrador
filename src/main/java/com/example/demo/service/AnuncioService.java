package com.example.demo.service;

import com.example.demo.entity.Anuncio;
import com.example.demo.repository.AnuncioRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Service
public class AnuncioService {

    @Autowired
    private AnuncioRepository anuncioRepository;

    //REFATORAR O RETORNO DO METODO
    public void save(Anuncio anuncio){
        this.anuncioRepository.save(anuncio);
    }
}
