package ru.practicum.shareit.exception;

public class ServerError extends RuntimeException {
    public ServerError(final String m) {
        super(m);
    }
}
