package dev.java10x.EventClean.core.usecases;

import dev.java10x.EventClean.core.entities.Evento;
import dev.java10x.EventClean.core.gateway.EventoGateway;

import java.util.List;

public class BuscarEventoUseCaseImpl implements BuscarEventoUseCase {

    private final EventoGateway eventoGateway;

    public BuscarEventoUseCaseImpl(EventoGateway eventoGateway) {
        this.eventoGateway = eventoGateway;
    }

    @Override
    public List<Evento> execute (){
        return eventoGateway.buscarEvento();
    }
}
