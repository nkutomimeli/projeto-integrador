package com.example.demo.repository;

import com.example.demo.entity.OrdemEntrada;
import com.example.demo.interfaces.CapacidadeSetor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdemEntradaRepository extends JpaRepository <OrdemEntrada, Long> {

}


