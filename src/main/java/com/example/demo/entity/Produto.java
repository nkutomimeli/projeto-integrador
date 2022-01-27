package com.example.demo.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public class Produto {
    private UUID id;
    private OrdemCadastro ordemCadastro;
    private Double temperaturaAtual;
    private Double temperaturaMinima;
    private Integer quantidadeInicial;
    private Integer quantidadeAtual;
    private LocalDateTime dataProducao;
    private LocalDate dataValidade;
}
