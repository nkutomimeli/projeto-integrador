package com.example.demo.repository;

import com.example.demo.entity.OrdemCadastro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdemCadastroRepository extends JpaRepository <OrdemCadastro, Long> {
}
