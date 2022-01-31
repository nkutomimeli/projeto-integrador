package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrdemEntrada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dataCriacao;

    @ManyToOne
    @JoinColumn(name="setor_id")
    private Setor setor;

    @OneToMany(mappedBy="ordemEntrada")
    @ToString.Exclude
    @JsonManagedReference
    private Set<Estoque> estoques;
}
