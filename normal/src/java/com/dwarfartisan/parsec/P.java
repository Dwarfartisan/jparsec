package com.dwarfartisan.parsec;

import java.io.EOFException;

/**
 * Created by Mars Liu on 16/1/1.
 */
public interface P<T, E> {
    T parse(State<E> s) throws EOFException, ParsecException;
}
