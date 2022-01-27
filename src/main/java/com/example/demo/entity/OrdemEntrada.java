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

//    @Column(name = "id_ordem_entrada")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dataCriacao;

//    @JoinColumn(name="id_setor", nullable=false)
    @ManyToOne
    private Setor setor;

    @OneToMany(mappedBy="ordemEntrada") // ordem_entrada ???
    private Set<Estoque> estoques;
}
