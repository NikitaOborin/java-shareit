package ru.practicum.shareit.exception;

public class EntityNotAvailable extends RuntimeException {
    public EntityNotAvailable(final String m) {
        super(m);
    }
}