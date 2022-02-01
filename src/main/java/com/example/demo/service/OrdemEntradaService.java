package com.example.demo.service;

import com.example.demo.dto.EstoqueDTO;
import com.example.demo.dto.InboundOrderDTO;
import com.example.demo.entity.*;
import com.example.demo.repository.AnuncioRepository;
import com.example.demo.repository.EstoqueRepository;
import com.example.demo.repository.OrdemEntradaRepository;
import com.example.demo.repository.SetorRepository;
import exception.BusinessException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

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

    @SneakyThrows
    public List<EstoqueDTO> save(InboundOrderDTO inboundOrderDTO){
        Setor setor = this.setorRepository.getById(inboundOrderDTO.getOrdemEntradaDTO().getSetor_id());

        //SALVA ORDEM DE ENTRADA
        OrdemEntrada ordemEntradaSalva = saveOrdemEntrada(
            OrdemEntrada.builder()
            .setor(setor)
            .dataCriacao(inboundOrderDTO.getOrdemEntradaDTO().getDataCriacao())
            .build()
        );

        // SALVO O ESTOQUE
        Set<EstoqueDTO> listaEstoque = inboundOrderDTO.getListaEstoqueDTO();
        saveListaEstoque(listaEstoque, ordemEntradaSalva, setor);

        List<Estoque> estoqueCadastrado = this.estoqueRepository.findAllEstoque(ordemEntradaSalva);
        return EstoqueDTO.converte(estoqueCadastrado);
    }

    @SneakyThrows
    public InboundOrderDTO update(InboundOrderDTO inboundOrderDTO, Long id) {
        OrdemEntrada ordemEntrada = this.ordemEntradaRepository.findById(id).orElse(new OrdemEntrada());
        Setor setor = this.setorRepository.findById(inboundOrderDTO.getOrdemEntradaDTO().getSetor_id()).orElse(new Setor());
        ordemEntrada.setSetor(setor);
        ordemEntrada.setDataCriacao(inboundOrderDTO.getOrdemEntradaDTO().getDataCriacao());

        //SALVA ORDEM DE ENTRADA
        OrdemEntrada ordemEntradaSalva = saveOrdemEntrada(ordemEntrada);

        // SALVO O ESTOQUE
        Set<EstoqueDTO> listaEstoque = inboundOrderDTO.getListaEstoqueDTO();
        saveListaEstoque(listaEstoque, ordemEntradaSalva, setor);

        return InboundOrderDTO.converte(ordemEntradaSalva);
    }


    //---------------------//
    // MÉTODOS AUXILIARES //
    //---------------------//

    public OrdemEntrada getOrdemById(Long id) {
        OrdemEntrada ordemEntrada = this.ordemEntradaRepository.findById(id).orElse(new OrdemEntrada());
        return ordemEntrada;
    }

    private OrdemEntrada saveOrdemEntrada(OrdemEntrada ordemEntrada) throws BusinessException {
        try{
            return this.ordemEntradaRepository.save(ordemEntrada);
        } catch (Exception e){
            throw new BusinessException("Setor não cadastrado.");
        }
    }

    private void saveListaEstoque(Set<EstoqueDTO> listaEstoque, OrdemEntrada ordemEntrada, Setor setor){
        listaEstoque.forEach(estoque -> {
            saveEstoque(estoque, ordemEntrada, setor);
        });
    }

    private void saveEstoque(EstoqueDTO estoque, OrdemEntrada ordemEntrada, Setor setor){
        Anuncio anuncio = this.anuncioRepository.findById(estoque.getAnuncio_id()).orElse(new Anuncio());

        //VALIDAR O TIPO DO PRODUTO == TIPO DO SETOR
        if (anuncio.getTipo().getDescricao().equals(setor.getNome())) {
            Estoque estoqueConvertido = EstoqueDTO.converte(estoque, anuncio, ordemEntrada);
            this.estoqueRepository.save(estoqueConvertido);
        } else {
            throw new RuntimeException("Setor inválido");
        }

        //VALIDAR O ESPACO DISPONIVEL DO SETOR
        /*
        Collection<VolumeEstoqueAtualizado>  tupla = this.ordemEntradaRepository.findAllSetor();
        System.out.println();
        tupla.forEach((setor1 -> {
            System.out.println(setor1.toString());
        }));
         */

    }
}
