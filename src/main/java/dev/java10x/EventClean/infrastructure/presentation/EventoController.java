package dev.java10x.EventClean.infrastructure.presentation;

import dev.java10x.EventClean.core.entities.Evento;
import dev.java10x.EventClean.core.usecases.BuscarEventoUseCase;
import dev.java10x.EventClean.core.usecases.CriarEventoUseCase;
import dev.java10x.EventClean.infrastructure.dtos.EventoDto;
import dev.java10x.EventClean.infrastructure.mapper.EventoDtoMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class EventoController {

    private final CriarEventoUseCase criarEventoUseCase;
    private final BuscarEventoUseCase buscarEventoUseCase;
    private final EventoDtoMapper eventoDtoMapper;

    public EventoController(CriarEventoUseCase criarEventoUseCase, BuscarEventoUseCase buscarEventoUseCase, EventoDtoMapper eventoDtoMapper) {
        this.criarEventoUseCase = criarEventoUseCase;
        this.buscarEventoUseCase = buscarEventoUseCase;
        this.eventoDtoMapper = eventoDtoMapper;
    }

    @PostMapping("criarevento")
    public EventoDto criarEvento(@RequestBody EventoDto eventoDto){
        Evento novoEvento = criarEventoUseCase.execute(eventoDtoMapper.ToEntity(eventoDto));
        return eventoDtoMapper.toDto(novoEvento);
    }

    @GetMapping("buscareventos")
    public List<EventoDto> buscarEventos(){
        return buscarEventoUseCase.execute().stream()
                .map(eventoDtoMapper::toDto)
                .toList();
    }
}
