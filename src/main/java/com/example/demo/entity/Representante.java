package com.example.demo.entity;

import javax.persistence.*;

@Entity
public class Representante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

//    @ManyToOne
//    @JoinColumn(name="armazem_id", nullable=false)
    private Armazem armazem;
}
