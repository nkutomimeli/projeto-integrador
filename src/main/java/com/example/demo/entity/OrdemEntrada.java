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
public class OrdemEntrada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dataCriacao;

    @ManyToOne
    @JoinColumn(name="id", nullable=false)
    private Setor setor;

    @OneToMany(mappedBy="ordemEntrada") // ordem_entrada ???
    private Set<Estoque> estoques;
}
