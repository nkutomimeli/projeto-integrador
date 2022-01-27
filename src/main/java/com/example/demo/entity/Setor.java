package com.example.demo.entity;

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

//    @Column(name = "setor_id")
//    @Column(name = "id_setor")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @JoinColumn(name="id_armazem", nullable=false) // insertable = false, updatable = false)
    @ManyToOne
    private Armazem armazem;

    private String nome;
    private Double volume;

    @OneToMany(mappedBy="setor")
    private Set<OrdemEntrada> ordemEntradas;

}
