package com.example.demo.repository;

import com.example.demo.entity.Setor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SetorRepository extends JpaRepository <Setor, Long>  {
}
