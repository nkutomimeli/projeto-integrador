package com.example.demo.service;

import com.example.demo.dto.ListaArmazemDTO;
import com.example.demo.entity.Estoque;
import com.example.demo.interfaces.ListaArmazemInterface;
import com.example.demo.repository.ArmazemRepository;
import com.example.demo.repository.EstoqueRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Service
public class ArmazemService {

    @Autowired
    private EstoqueRepository estoqueRepository;

    public List<ListaArmazemDTO> estoquePorArmazem (Long produto_id) {
        List<ListaArmazemInterface> estoqueList = this.estoqueRepository.getEstoqueByArmazem(produto_id);
        estoqueList.forEach((item -> {
            System.out.println(item.getArmazem_id());
            System.out.println(item.getTotalQuantidade());
        }));
        System.out.println(estoqueList);
        return null;
    }

}
