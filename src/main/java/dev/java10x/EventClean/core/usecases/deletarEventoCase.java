package dev.java10x.EventClean.core.usecases;

import dev.java10x.EventClean.core.entities.Evento;

public interface deletarEventoCase {
    public Evento execute (Long id);
}
