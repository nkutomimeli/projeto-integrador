package com.example.demo.entity;

import com.example.demo.enums.Tipos;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
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
    private Tipos tipo; // ENUM  CONGELADO (1, "Congelado"), REFRIGERADO (2, "Refrigerado"), FRESCO  (3, "Fresco");

    @OneToMany(mappedBy="anuncio")
    @ToString.Exclude
    @JsonBackReference
    private Set<Estoque> estoques;

    @OneToMany(mappedBy="anuncio")
    @ToString.Exclude
    @JsonBackReference
    private Set<ItemCarrinho> itensCarrinho;
}
