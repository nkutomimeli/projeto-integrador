package com.example.demo.repository;

import com.example.demo.entity.Anuncio;
import com.example.demo.enums.Tipos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.time.LocalDate;
import java.util.List;


@Repository
public interface AnuncioRepository extends JpaRepository <Anuncio, Long> {

    @Query("SELECT distinct a " +
            "from Anuncio a " +
            "JOIN fetch a.estoques estoques " +
            "where estoques.quantidadeAtual > 0 and estoques.dataValidade > ?1") // '2022-02-23'
    List<Anuncio> findAllAnunciosWithStockAndDueDateValid(LocalDate dataValidade);

    @Query("SELECT distinct a " +
            "from Anuncio a " +
            "JOIN fetch a.estoques estoques " +
            "where a.tipo = ?2 and estoques.quantidadeAtual > 0 and estoques.dataValidade > ?1") // '2022-02-23'
    List<Anuncio> findAllAnunciosByCategoryWithStockAndDueDateValid(LocalDate dataValidade, Tipos categoria);

}
