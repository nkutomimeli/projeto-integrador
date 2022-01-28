package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Armazem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cep;

    @OneToMany(mappedBy="armazem")
    @JsonIgnore
    private Set<Setor> setors;

    @OneToMany(mappedBy="armazem")
    @JsonIgnore
    private Set<Representante> representantes;
}
