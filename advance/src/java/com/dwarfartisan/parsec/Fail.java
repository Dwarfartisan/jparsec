package com.dwarfartisan.parsec;

import java.io.EOFException;

/**
 * Created by Mars Liu on 2016-01-07.
 * Fail 不改变 state , 直接抛出预设的异常.
 */
public class Fail<T, E> implements Parsec<T, E> {
    private String message;

    @Override
    public T parse(State<E> s) throws EOFException, ParsecException {
        throw new ParsecException(s.index(), message);
    }

    public Fail(String msg, Object...objects) {
        message = String.format(msg, objects);
    }
}
