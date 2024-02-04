package com.remedios.projeto.dto.remedio;

import com.remedios.projeto.domain.remedio.Laboratorio;
import com.remedios.projeto.domain.remedio.Via;
import com.remedios.projeto.domain.remedio.Remedio;

import java.time.LocalDate;

public record ListagemRemedioDTO(
        Long id,
        String nome,
        Via via,
        String lote,
        Laboratorio laboratorio,
        LocalDate validade) {


    public ListagemRemedioDTO(Remedio remedio) {
        this(remedio.getId(),
                remedio.getNome(),
                remedio.getVia(),
                remedio.getLote(),
                remedio.getLaboratorio(),
                remedio.getValidade());
    }
}
