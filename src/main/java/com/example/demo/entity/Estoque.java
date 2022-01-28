package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class Estoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="anuncio_id")
    private Anuncio anuncio;

    @ManyToOne
    @JoinColumn(name="ordem_entrada_id")
    private OrdemEntrada ordemEntrada;

    private Integer quantidadeInicial;
    private Integer quantidadeAtual;
    private Double temperaturaAtual;
    private LocalDate dataValidade;
    private LocalDateTime dataProducao;

}
