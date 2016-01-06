package com.dwarfartisan.parsec;

import java.io.EOFException;

/**
 * Created by Mars Liu on 2016-01-03.
 */
public class Eq<E> implements Parsec<E, E> {
    E item;
    @Override
    public E parse(State<E> s) throws EOFException, ParsecException {
        E re = s.next();
        if (re==item){
            return re;
        } else {
            String message = String.format("Expect %s is equal to %s", re, item);
            throw new ParsecException(s.index(), message);
        }
    }
    public Eq(E item){
        this.item = item;
    }
}
