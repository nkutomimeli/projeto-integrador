package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

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

    @ManyToOne
    @ToString.Exclude
//    @JsonManagedReference
    @JsonIgnoreProperties("estoques")
    @JoinColumn(name="anuncio_id")
    private Anuncio anuncio;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonBackReference
    @JoinColumn(name="ordem_entrada_id")
    private OrdemEntrada ordemEntrada;


    private Integer quantidadeInicial;
    private Integer quantidadeAtual;
    private Double temperaturaAtual;
    private LocalDate dataValidade;
    private LocalDateTime dataProducao;

}
