package ru.practicum.shareit.exception;

public class UnsupportedState extends RuntimeException {
    public UnsupportedState(final String m) {
        super(m);
    }
}