package com.dwarfartisan.parsec;

import java.io.EOFException;

/**
 * Created by Mars Liu on 2016-01-07.
 */
public class Fail<T, E> implements Parsec<T, E> {
    String message;

    @Override
    public T parse(State<E> s) throws EOFException, ParsecException {
        throw new ParsecException(s.index(), message);
    }

    @SafeVarargs
    public Fail(String msg, Object...objects) {
        message = String.format(msg, objects);
    }
}
