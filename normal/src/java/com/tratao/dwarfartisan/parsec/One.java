package com.tratao.dwarfartisan.parsec;

import java.io.EOFException;

/**
 * Created by Mars Liu on 16/1/1.
 */
public class One<T> implements Parsec<T, T> {
    public T parse(State<T> s) throws EOFException, ParsecException {
        return s.next();
    }
}
