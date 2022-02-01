package com.example.demo.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Validated
public class OrdemEntradaDTO {

    @NotNull(message = "OrdemEntradaDTO em branco, favor fornecê-lo!")
    @Past(message = "OrdemEntradaDTO ter uma data do futuro.")
    private LocalDateTime dataCriacao;



    @NotNull
    private Long setor_id;
}
