package dev.java10x.EventClean.core.gateway;

import dev.java10x.EventClean.core.entities.Evento;

import java.util.List;

public interface EventoGateway {

    Evento criarEvento(Evento evento);

    List<Evento> buscarEvento();

    Boolean existsByIdentificador(String identificador);

    Evento buscarEventoPorId(Long id);
}
