package com.example.demo.service;

import com.example.demo.dto.ArmazemDTO;
import com.example.demo.dto.ListaArmazemDTO;
import com.example.demo.exception.ProdutoVazioException;
import com.example.demo.interfaces.ListaArmazemInterface;
import com.example.demo.repository.EstoqueRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Service
public class ArmazemService {

    @Autowired
    private EstoqueRepository estoqueRepository;


    public ArmazemDTO getEstoqueByArmazem(Long produto_id) {
        ArmazemDTO armazemDTO = new ArmazemDTO();
        armazemDTO.produto_id(produto_id);
        List<ListaArmazemDTO> listaInterandoArmazem = new ArrayList<>();
        List<ListaArmazemInterface> estoqueList = this.estoqueRepository.getEstoqueByArmazem(produto_id);
        estoqueList.forEach((item -> {
                    ListaArmazemDTO result = new ListaArmazemDTO(item.getArmazem_id(), item.getTotalQuantidade()).build();
                    listaInterandoArmazem.add(result);
                }));
        armazemDTO.listaArmazem((listaInterandoArmazem));
        if (listaInterandoArmazem.isEmpty()) throw new ProdutoVazioException("Nenhum produto encontrado.");
        return armazemDTO;
    }
}
