package com.example.demo.service;

import com.example.demo.dto.InboundOrderDTO;
import com.example.demo.entity.*;
import com.example.demo.repository.EstoqueRepository;
import com.example.demo.repository.OrdemEntradaRepository;
import com.example.demo.repository.SetorRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Service
public class OrdemEntradaService {

    @Autowired
    OrdemEntradaRepository ordemEntradaRepository;

    @Autowired
    EstoqueRepository estoqueRepository;

    @Autowired
    SetorRepository setorRepository;

    public Set<Estoque> save(InboundOrderDTO ordemEntradaDTO){
        OrdemEntrada ordemEntrada = new OrdemEntrada();

        Setor setor = this.setorRepository.findById(ordemEntradaDTO.getOrdemEntradaDTO().getSetor_id()).orElse(new Setor());
        ordemEntrada.setSetor(setor);
        ordemEntrada.setEstoques(ordemEntradaDTO.getListaEstoque());
        ordemEntrada.setDataCriacao(ordemEntradaDTO.getOrdemEntradaDTO().getDataCriacao());

        // SALVO A ORDEM DE ENTRADA
        this.ordemEntradaRepository.save(ordemEntrada);

        // SALVO O ESTOQUE
        Set<Estoque> listaEstoque = ordemEntradaDTO.getListaEstoque();
        listaEstoque.stream().forEach((estoque -> {
            this.estoqueRepository.save(estoque);
        }));
        return listaEstoque;
    }
}
