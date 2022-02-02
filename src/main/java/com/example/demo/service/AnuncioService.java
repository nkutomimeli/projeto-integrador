package com.example.demo.service;

import com.example.demo.entity.Anuncio;
import com.example.demo.entity.Estoque;
import com.example.demo.enums.Tipos;
import com.example.demo.exception.AnunciosVaziosException;
import com.example.demo.repository.AnuncioRepository;
import com.example.demo.repository.EstoqueRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Service
public class AnuncioService {

    @Autowired
    private AnuncioRepository anuncioRepository;

    private EstoqueRepository estoqueRepository;

    public List<Anuncio> listAnunciosValidos() {
        // Listar todos os anúncios válidos com quantidade atual maior
        // que zero e validade de pelo menos 3 semanas

        LocalDate dataValidadeMais3Semanas = LocalDate.now().plusWeeks(3);
        List<Anuncio> anuncios = this.anuncioRepository.findAllAnunciosWithStockAndDueDateValid(dataValidadeMais3Semanas);
        if (anuncios.isEmpty()) throw new AnunciosVaziosException("Nenhum anúncio encontrado.");
        return anuncios;
    }

    public List<Anuncio> listAnunciosByCategory(Tipos categoria) {
        // Listar todos os anúncios válidos com quantidade atual maior
        // que zero e validade de pelo menos 3 semanas, por categoria
        // FRESCO, REFRIGERADO ou CONGELADO
        LocalDate dataValidadeMais3Semanas = LocalDate.now().plusWeeks(3);
        List<Anuncio> anuncios = this.anuncioRepository.findAllAnunciosByCategoryWithStockAndDueDateValid(dataValidadeMais3Semanas, categoria);
        if (anuncios.isEmpty()) throw new AnunciosVaziosException("Nenhum anúncio encontrado.");
        return anuncios;
    }
}
