package com.dwarfartisan.parsec;

import java.io.EOFException;

/**
 * Created by Mars Liu on 2016-01-02.
 */
public interface Binder<T, C, E> {
    Parsec<C, E> bind(T value);
}
