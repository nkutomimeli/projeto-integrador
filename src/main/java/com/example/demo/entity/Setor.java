package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class Setor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="armazem_id") // insertable = false, updatable = false)
    private Armazem armazem;

    private String nome; // CONGELADO, REFRIGERADO, FRESCO
    private Double volume;

    @OneToMany(mappedBy="setor")
    private Set<OrdemEntrada> ordemEntradas;

}

