package com.dwarfartisan.parsec;

import java.io.EOFException;

/**
 * Created by Mars Liu on 16/1/1.
 */
public class Eq<T> extends Parsec<T, T> {
    private T item;
    @Override
    public T parse(State<T> s) throws EOFException, ParsecException {
        T re = s.next();
        if (re == item) {
            return re;
        } else {
            String message = String.format("Expect a item equals to %s, but got %s", this.item, re);
            throw new ParsecException(s.index(), message);
        }
    }
    public Eq(T item) {
        this.item = item;
    }
}
