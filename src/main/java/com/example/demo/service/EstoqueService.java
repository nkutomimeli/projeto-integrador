package com.example.demo.service;

import com.example.demo.dto.EstoqueSetorIdDataValidadeDTO;
import com.example.demo.entity.Estoque;
import com.example.demo.enums.Tipos;
import com.example.demo.repository.EstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

@Service
public class EstoqueService {

    @Autowired
    EstoqueRepository estoqueRepository;

    public List<EstoqueSetorIdDataValidadeDTO> getAllEstoqueBySetorIdDataValidade(Long setorId, Long numeroDias){
        LocalDate dataValidade = LocalDate.now().plusDays(numeroDias);
        return EstoqueSetorIdDataValidadeDTO.converte(this.estoqueRepository.getAnunciosBySetorValidadeRep(1L, setorId, dataValidade));
    }

    public List<EstoqueSetorIdDataValidadeDTO> getEstoqueByDataValidadeCategoria(Long numeroDias, int categoria, String order) {
        LocalDate dataValidade = LocalDate.now().plusDays(numeroDias);
        List<Estoque> estoque = this.estoqueRepository.getEstoqueByDataValidadeCategoria(dataValidade, categoria);
        estoque.sort(Comparator.comparing(Estoque::getDataValidade));
        if(order.equals("desc")){
            estoque.sort(Comparator.comparing(Estoque::getDataValidade).reversed());
        }
        return EstoqueSetorIdDataValidadeDTO.converte(estoque);
    }
}
