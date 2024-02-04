package com.remedios.projeto.dto.remedio;

import com.remedios.projeto.domain.remedio.Laboratorio;
import com.remedios.projeto.domain.remedio.Via;
import jakarta.validation.constraints.NotNull;

public record AtualizarRemedioDTO(
        @NotNull
        Long id,
        String nome,
        Via via,
        Laboratorio laboratorio) {
}
