package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Setor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="armazem_id", nullable=false) // insertable = false, updatable = false)
    @JsonIgnore
    private Armazem armazem;

    private String nome;
    private Double volume;

    @OneToMany(mappedBy="setor")
    @JsonIgnore
    private Set<OrdemEntrada> ordemEntradas;

}
