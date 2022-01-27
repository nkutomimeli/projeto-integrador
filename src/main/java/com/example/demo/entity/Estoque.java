package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Estoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @JoinColumn(name="id_anuncio", nullable=false)
    @ManyToOne
    private Anuncio anuncio;

//    @JoinColumn(name="id_ordem_entrada", nullable=false)
    @ManyToOne
    private OrdemEntrada ordemEntrada;

    private Integer quantidadeInicial;
    private Integer quantidadeAtual;
    private Double temperaturaAtual;
    private LocalDate dataValidade;
    private LocalDateTime dataProducao;

}
