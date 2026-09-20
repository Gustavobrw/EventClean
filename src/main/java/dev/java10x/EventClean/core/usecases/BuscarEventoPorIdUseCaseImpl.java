package dev.java10x.EventClean.core.usecases;

import dev.java10x.EventClean.core.entities.Evento;
import dev.java10x.EventClean.core.gateway.EventoGateway;

public class BuscarEventoPorIdUseCaseImpl implements BuscarEventoPorIdUseCase {

    private final EventoGateway eventoGateway;

    public BuscarEventoPorIdUseCaseImpl(EventoGateway eventoGateway) {
        this.eventoGateway = eventoGateway;
    }

    public Evento execute (Long id){
        return eventoGateway.buscarEventoPorId(id);
    }
}
