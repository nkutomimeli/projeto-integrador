package com.example.demo.dto;

import com.example.demo.entity.Anuncio;
import com.example.demo.entity.Estoque;
import com.example.demo.entity.OrdemEntrada;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EstoqueDTO {

    private Long id;
    private Long anuncio_id;
    private Long ordem_entrada_id;
    private Integer quantidadeInicial;
    private Integer quantidadeAtual;
    private Double temperaturaAtual;
    private LocalDate dataValidade;
    private LocalDateTime dataProducao;

    public static Estoque converte(EstoqueDTO dto, Anuncio anuncio, OrdemEntrada ordemEntrada) {
        Estoque estoque = Estoque.builder()
                .id(dto.getId())
                .anuncio(anuncio)
                .ordemEntrada(ordemEntrada)
                .quantidadeInicial(dto.getQuantidadeInicial())
                .quantidadeAtual(dto.getQuantidadeAtual())
                .temperaturaAtual(dto.getTemperaturaAtual())
                .dataValidade(dto.getDataValidade())
                .dataProducao(dto.getDataProducao())
                .build();
        return estoque;
    }

    public static EstoqueDTO converte(Estoque e) {
        EstoqueDTO dto = EstoqueDTO.builder()
                .id(e.getId())
                .anuncio_id(e.getAnuncio().getId())
                .ordem_entrada_id(e.getOrdemEntrada().getId())
                .quantidadeInicial(e.getQuantidadeInicial())
                .quantidadeAtual(e.getQuantidadeAtual())
                .temperaturaAtual(e.getTemperaturaAtual())
                .dataValidade(e.getDataValidade())
                .dataProducao(e.getDataProducao())
                .build();
        return dto;
    }

    public static List<EstoqueDTO> converte(List<Estoque> estoque) {
        return estoque.stream().map(EstoqueDTO::converte).collect(Collectors.toList());
    }

    public static Set<EstoqueDTO> converte(Set<Estoque> estoque) {
        return estoque.stream().map(EstoqueDTO::converte).collect(Collectors.toSet());
    }
}
