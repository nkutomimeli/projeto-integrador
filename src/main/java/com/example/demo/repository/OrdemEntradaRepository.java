package com.example.demo.repository;

import com.example.demo.bean.VolumeEstoqueAtualizado;
import com.example.demo.entity.OrdemEntrada;
import com.example.demo.interfaces.VolumeEstoqueDisponivel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface OrdemEntradaRepository extends JpaRepository <OrdemEntrada, Long> {

    @Query(value = "SELECT s. nome, s.volume - SUM(a.volume * e.quantidade_atual) AS volume " +
            "FROM ordem_entrada oe INNER JOIN estoque e ON e.ordem_entrada_id = oe.id " +
            "INNER JOIN anuncio a ON a.id = e.anuncio_id " +
            "INNER JOIN setor s ON s.id = oe.setor_id " +
            "WHERE oe.setor_id IN (1,2, 3) " +
            "GROUP BY s.nome, s.volume", nativeQuery = true)
    Collection<VolumeEstoqueAtualizado> findAllSetor();
    /*

    */

//    SELECT s. nome, s.volume - SUM(a.volume * e.quantidade_atual) FROM ordem_entrada oe
//    INNER JOIN estoque e ON e.ordem_entrada_id = oe.id
//    INNER JOIN anuncio a ON a.id = e.anuncio_id
//    INNER JOIN setor s ON s.id = oe.setor_id
//    WHERE oe.setor_id IN (1,2, 3)
//    GROUP BY s.nome, s.volume;

}

