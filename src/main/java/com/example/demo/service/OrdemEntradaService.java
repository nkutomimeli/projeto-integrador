package com.example.demo.service;

import com.example.demo.dto.EstoqueDTO;
import com.example.demo.dto.InboundOrderDTO;
import com.example.demo.dto.OrdemEntradaDTO;
import com.example.demo.entity.*;
import com.example.demo.repository.AnuncioRepository;
import com.example.demo.repository.EstoqueRepository;
import com.example.demo.repository.OrdemEntradaRepository;
import com.example.demo.repository.SetorRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.HashSet;
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

    public List<EstoqueDTO> save(InboundOrderDTO inboundOrderDTO){
        OrdemEntrada ordemEntrada = new OrdemEntrada();

        Setor setor = this.setorRepository.findById(inboundOrderDTO.getOrdemEntradaDTO().getSetor_id()).orElse(new Setor());
        ordemEntrada.setSetor(setor);
        ordemEntrada.setDataCriacao(inboundOrderDTO.getOrdemEntradaDTO().getDataCriacao());

        OrdemEntrada ordemEntradaSalva = this.ordemEntradaRepository.save(ordemEntrada);

        // SALVO O ESTOQUE
        Set<EstoqueDTO> listaEstoque = inboundOrderDTO.getListaEstoqueDTO();
        listaEstoque.forEach((estoque -> {
            Anuncio anuncio = this.anuncioRepository.findById(estoque.getAnuncio_id()).orElse(new Anuncio());
            Estoque estoqueConvertido = EstoqueDTO.converte(estoque, anuncio, ordemEntradaSalva);
            this.estoqueRepository.save(estoqueConvertido);
        }));

        List<Estoque> estoqueCadastrado = this.estoqueRepository.findAllEstoque(ordemEntradaSalva);
        return EstoqueDTO.converte(estoqueCadastrado);
    }

    public InboundOrderDTO atualiza(InboundOrderDTO inboundOrderDTO, Long id) {
        OrdemEntrada ordemEntrada = this.ordemEntradaRepository.findById(id).orElse(new OrdemEntrada());
//        OrdemEntrada ordemEntrada = this.ordemEntradaRepository.findAll();

        Setor setor = this.setorRepository.findById(inboundOrderDTO.getOrdemEntradaDTO().getSetor_id()).orElse(new Setor());



        ordemEntrada.setSetor(setor);
        ordemEntrada.setDataCriacao(inboundOrderDTO.getOrdemEntradaDTO().getDataCriacao());

        OrdemEntrada ordemEntradaAtualizada = this.ordemEntradaRepository.saveAndFlush(ordemEntrada);

        Set<EstoqueDTO> listaEstoque = inboundOrderDTO.getListaEstoqueDTO();
        listaEstoque.forEach((estoque -> {
            Anuncio anuncio = this.anuncioRepository.findById(estoque.getAnuncio_id()).orElse(new Anuncio());
            Estoque estoqueConvertido = EstoqueDTO.converte(estoque, anuncio, ordemEntradaAtualizada);
            ordemEntradaAtualizada.getEstoques().add(this.estoqueRepository.saveAndFlush(estoqueConvertido));
        }));

        return InboundOrderDTO.converte(ordemEntradaAtualizada);
    }

    public OrdemEntrada getOrdemById(Long id) {
        OrdemEntrada ordemEntrada = this.ordemEntradaRepository.findById(id).orElse(new OrdemEntrada());
        return ordemEntrada;
    }
}
