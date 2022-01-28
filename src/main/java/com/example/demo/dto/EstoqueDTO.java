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

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EstoqueDTO {

    private Long anuncio_id;
    private Long ordem_entrada_id;
    private Integer quantidadeInicial;
    private Integer quantidadeAtual;
    private Double temperaturaAtual;
    private LocalDate dataValidade;
    private LocalDateTime dataProducao;

    /*public static Estoque converte(EstoqueDTO dto) {
        return Estoque.builder()
                .anuncio(dto.getAnuncio_id())
                .ordemEntrada(dto.getOrdem_entrada_id())
                .quantidadeInicial(dto.getQuantidadeInicial())
                .temperaturaAtual(dto.getTemperaturaAtual())
                .dataValidade(dto.getDataValidade())
                .dataProducao(dto.getDataProducao())
                .build();
    }*/
    public static Estoque converte(EstoqueDTO dto, Anuncio anuncio, OrdemEntrada ordemEntrada) {
        Estoque estoque = Estoque.builder()
                .anuncio(anuncio)
                .ordemEntrada(ordemEntrada)
                .quantidadeInicial(dto.getQuantidadeInicial())
                .temperaturaAtual(dto.getTemperaturaAtual())
                .dataValidade(dto.getDataValidade())
                .dataProducao(dto.getDataProducao())
                .build();
        return estoque;
    }

    public static List<Estoque> converte(List<EstoqueDTO> listaDTO) {
        return listaDTO.stream().map(p -> converte(p)).collect(Collectors.toList());
    }
}
