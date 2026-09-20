package dev.java10x.EventClean.infrastructure.exception;

public class EventDuplicateException extends RuntimeException{
    public EventDuplicateException(String message) {
        super(message);
    }
}
