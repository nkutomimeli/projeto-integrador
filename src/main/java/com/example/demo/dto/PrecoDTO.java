package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PrecoDTO {
    @JsonIgnore
    private Long id;
    private BigDecimal subtotal;
    private BigDecimal frete;
    private BigDecimal total;
}
