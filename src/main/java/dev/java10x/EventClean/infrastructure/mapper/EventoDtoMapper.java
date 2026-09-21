package dev.java10x.EventClean.infrastructure.mapper;

import dev.java10x.EventClean.core.entities.Evento;
import dev.java10x.EventClean.infrastructure.dtos.EventoDto;
import dev.java10x.EventClean.infrastructure.dtos.EventoRequestDto;
import org.springframework.stereotype.Component;

@Component
public class EventoDtoMapper {

    public EventoDto toDto(Evento evento){
        return new EventoDto(
                evento.id(),
                evento.nome(),
                evento.descricao(),
                evento.identificador(),
                evento.dataInicio(),
                evento.dataFim(),
                evento.localEvento(),
                evento.capacidade(),
                evento.organizador(),
                evento.tipo()
        );
    }

    public Evento ToEntity(EventoRequestDto eventoDto){
        return new Evento(
                null,
                eventoDto.nome(),
                eventoDto.descricao(),
                null,
                eventoDto.dataInico(),
                eventoDto.dataFim(),
                eventoDto.localEvento(),
                eventoDto.capacidade(),
                eventoDto.organizador(),
                eventoDto.tipo()
        );
    }
}
