package dev.java10x.EventClean.core.usecases;

import dev.java10x.EventClean.core.gateway.EventoGateway;

public class RandomIdentificadorUseCaseImpl implements RandomIdentificadorUseCase {

    private final EventoGateway eventoGateway;

    public RandomIdentificadorUseCaseImpl(EventoGateway eventoGateway) {
        this.eventoGateway = eventoGateway;
    }

    @Override
    public String execute() {
        return eventoGateway.generateRandomIndentificador();
    }
}
