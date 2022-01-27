package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Anuncio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="produto_id", nullable=false)
    private Produto produto;

    @ManyToOne
    @JoinColumn(name="vendedor_id", nullable=false)
    private Vendedor vendedor;

    private BigDecimal preco; // em R$
    private Double volume; // em m3
    private Double temperaturaMaxima;
    private Double temperaturaMinima;

    @OneToMany(mappedBy="anuncio")
    private Set<Estoque> estoques;
}
