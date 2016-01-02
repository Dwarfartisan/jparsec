package com.dwarfartisan.parsec;

import java.io.EOFException;

/**
 * Created by Mars Liu on 2016-01-02.
 */
public class One<E> implements Parsec<E, E> {
    @Override
    public E parse(State<E> s) throws EOFException, ParsecException {
        return s.next();
    }
}
