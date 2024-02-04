package com.remedios.projeto.dto.remedio;

import com.remedios.projeto.domain.remedio.Laboratorio;
import com.remedios.projeto.domain.remedio.Via;
import com.remedios.projeto.domain.remedio.Remedio;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


import java.time.LocalDate;

public record RemedioDTO(

        Long id,
        @NotBlank
        String nome,
        @Enumerated
        Via via,
        @NotBlank
        String lote,
        @NotNull
        int quantidade,
        @Future
        LocalDate validade,
        @Enumerated
        Laboratorio laboratorio) {

    public static RemedioDTO fromRemedio(Remedio remedio) {
        return new RemedioDTO(remedio.getId(),
                remedio.getNome(),
                remedio.getVia(),
                remedio.getLote(),
                remedio.getQuantidade(),
                remedio.getValidade(),
                remedio.getLaboratorio());
    }

}