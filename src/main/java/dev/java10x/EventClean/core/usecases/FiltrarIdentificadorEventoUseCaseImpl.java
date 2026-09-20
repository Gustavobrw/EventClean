package dev.java10x.EventClean.core.usecases;

import dev.java10x.EventClean.core.entities.Evento;
import dev.java10x.EventClean.core.gateway.EventoGateway;
import dev.java10x.EventClean.infrastructure.exception.ValidationException;

public class FiltrarIdentificadorEventoUseCaseImpl implements FiltrarIdentificadorEventoUseCase {
    private final EventoGateway eventoGateway;

    public FiltrarIdentificadorEventoUseCaseImpl(EventoGateway eventoGateway) {
        this.eventoGateway = eventoGateway;
    }

    @Override
    public Evento execute(String identificador) {
        return eventoGateway.filtrarIdentificadorEvento(identificador)
                .orElseThrow(() -> new ValidationException("Evento não encontrado"));
    }
}
