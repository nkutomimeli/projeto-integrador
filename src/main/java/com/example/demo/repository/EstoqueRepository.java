package com.example.demo.repository;

import com.example.demo.entity.Anuncio;
import com.example.demo.entity.Estoque;
import com.example.demo.entity.OrdemEntrada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface EstoqueRepository extends JpaRepository <Estoque, Long> {
    @Query("SELECT e FROM Estoque e where e.ordemEntrada = ?1")
    List<Estoque> findAllEstoque(OrdemEntrada ordemEntrada);

    @Query(value = "select * from estoque where anuncio_id = ?1", nativeQuery = true)
    List<Estoque> findAllAnuncio(Long anuncio_id);

}
