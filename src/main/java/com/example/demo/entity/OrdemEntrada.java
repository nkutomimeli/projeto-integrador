package com.example.demo.entity;

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
    private Set<Estoque> estoques;
}
