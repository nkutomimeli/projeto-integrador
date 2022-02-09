package com.example.demo.repository;

import com.example.demo.entity.Veiculo;
import com.example.demo.enums.Tipos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
    Veiculo findByCategoria(Tipos tipo);
}
