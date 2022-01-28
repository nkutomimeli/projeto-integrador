package com.example.demo.service;

import com.example.demo.dto.EstoqueDTO;
import com.example.demo.dto.InboundOrderDTO;
import com.example.demo.entity.*;
import com.example.demo.repository.AnuncioRepository;
import com.example.demo.repository.EstoqueRepository;
import com.example.demo.repository.OrdemEntradaRepository;
import com.example.demo.repository.SetorRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Autowired
    AnuncioRepository anuncioRepository;

    public List<EstoqueDTO> save(InboundOrderDTO ordemEntradaDTO){
        OrdemEntrada ordemEntrada = new OrdemEntrada();

        Setor setor = this.setorRepository.findById(ordemEntradaDTO.getOrdemEntradaDTO().getSetor_id()).orElse(new Setor());
        ordemEntrada.setSetor(setor);
        ordemEntrada.setDataCriacao(ordemEntradaDTO.getOrdemEntradaDTO().getDataCriacao());

        // SALVO A ORDEM DE ENTRADA COM ESTOQUE VAZIO
        OrdemEntrada ordemEntradaSalvo = this.ordemEntradaRepository.save(ordemEntrada);

        // SALVO O ESTOQUE
        Set<EstoqueDTO> listaEstoque = ordemEntradaDTO.getListaEstoqueDTO();
        listaEstoque.forEach((estoque -> {
            Anuncio anuncio = this.anuncioRepository.findById(estoque.getAnuncio_id()).orElse(new Anuncio());
            Estoque estoqueConvertido = EstoqueDTO.converte(estoque, anuncio, ordemEntradaSalvo);
            this.estoqueRepository.save(estoqueConvertido);
        }));

        List<Estoque> estoqueCadastrado = this.estoqueRepository.findAllEstoque(ordemEntradaSalvo);
        return EstoqueDTO.converte(estoqueCadastrado);
    }

    public Setor get(Long id) {
        Setor setor = this.setorRepository.findById(1L).orElse(new Setor());
        return setor;
    }
}
