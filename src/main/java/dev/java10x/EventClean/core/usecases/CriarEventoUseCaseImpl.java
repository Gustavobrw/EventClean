package dev.java10x.EventClean.core.usecases;

import dev.java10x.EventClean.core.entities.Evento;
import dev.java10x.EventClean.core.gateway.EventoGateway;
import dev.java10x.EventClean.infrastructure.exception.EventDuplicateException;


public class CriarEventoUseCaseImpl implements CriarEventoUseCase {

    private final EventoGateway eventoGateway;

    public CriarEventoUseCaseImpl(EventoGateway eventoGateway) {
        this.eventoGateway = eventoGateway;
    }

    @Override
    public Evento execute(Evento evento) {
        if(eventoGateway.existsByIdentificador(evento.identificador())){
            throw new EventDuplicateException("Evento com identificador " + evento.identificador() + " já existe.");
        }

        return eventoGateway.criarEvento(evento);
    }
}
