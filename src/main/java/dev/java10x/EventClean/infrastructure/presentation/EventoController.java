package dev.java10x.EventClean.infrastructure.presentation;

import dev.java10x.EventClean.core.entities.Evento;
import dev.java10x.EventClean.core.usecases.BuscarEventoPorIdUseCase;
import dev.java10x.EventClean.core.usecases.BuscarEventoUseCase;
import dev.java10x.EventClean.core.usecases.CriarEventoUseCase;
import dev.java10x.EventClean.infrastructure.dtos.EventoDto;
import dev.java10x.EventClean.infrastructure.mapper.EventoDtoMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/")
public class EventoController {

    private final CriarEventoUseCase criarEventoUseCase;
    private final BuscarEventoUseCase buscarEventoUseCase;
    private final BuscarEventoPorIdUseCase buscarEventoPorIdUseCase;
    private final EventoDtoMapper eventoDtoMapper;

    public EventoController(CriarEventoUseCase criarEventoUseCase, BuscarEventoUseCase buscarEventoUseCase, BuscarEventoPorIdUseCase buscarEventoPorIdUseCase, EventoDtoMapper eventoDtoMapper) {
        this.criarEventoUseCase = criarEventoUseCase;
        this.buscarEventoUseCase = buscarEventoUseCase;
        this.buscarEventoPorIdUseCase = buscarEventoPorIdUseCase;
        this.eventoDtoMapper = eventoDtoMapper;
    }

    @PostMapping("criarevento")
    public ResponseEntity<Map<String, Object>> criarEvento(@RequestBody EventoDto eventoDto){
        Evento novoEvento = criarEventoUseCase.execute(eventoDtoMapper.ToEntity(eventoDto));

        Map<String, Object> response = new HashMap<>();
        response.put("Message: ", "Evento criado com sucesso!");
        response.put("Dados do evento: ", eventoDtoMapper.toDto(novoEvento));
        return ResponseEntity.ok(response);
    }

    @GetMapping("buscareventos")
    public List<EventoDto> buscarEventos(){
        return buscarEventoUseCase.execute().stream()
                .map(eventoDtoMapper::toDto)
                .toList();
    }

    @GetMapping("buscarevento/{id}")
    public ResponseEntity<EventoDto> buscarEventoPorId(@PathVariable Long id) {
        Evento evento = buscarEventoPorIdUseCase.execute(id);
        EventoDto eventoDto = eventoDtoMapper.toDto(evento);
        return ResponseEntity.ok(eventoDto);

    }

}
