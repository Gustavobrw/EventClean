package dev.java10x.EventClean.infrastructure.dtos;

import dev.java10x.EventClean.core.enuns.TipoEvento;

import java.time.LocalDateTime;

public record EventoRequestDto(
        String nome,
        String descricao,
        LocalDateTime dataInico,
        LocalDateTime dataFim,
        String localEvento,
        Integer capacidade,
        String organizador,
        TipoEvento tipo
) {
}
