package com.dwarfartisan.parsec;

import java.io.EOFException;

/**
 * Created by Mars Liu on 2016-01-07.
 * Fail 不改变 state , 直接抛出预设的异常.
 */
public class Fail<T, E, Status, Tran> implements Parsec<T, E, Status, Tran> {
    private String message;

    @Override
    public T parse(State<E, Status, Tran> s) throws EOFException, ParsecException {
        throw s.trap(message);
    }

    public Fail(String msg, Object...objects) {
        message = String.format(msg, objects);
    }
}
