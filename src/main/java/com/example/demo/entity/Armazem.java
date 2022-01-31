package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class Armazem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cep;

    @OneToMany(mappedBy="armazem")
    private Set<Setor> setors;

    @OneToMany(mappedBy="armazem")
    private Set<Representante> representantes;
}
