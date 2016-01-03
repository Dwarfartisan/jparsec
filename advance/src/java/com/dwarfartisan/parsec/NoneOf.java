package com.dwarfartisan.parsec;

import java.io.EOFException;

/**
 * Created by Mars Liu on 2016-01-03.
 */
public class NoneOf<E> implements Parsec<E, E> {
    private E[] items;

    @Override
    public E parse(State<E> s) throws EOFException, ParsecException {
        E re = s.next();
        for (E item : this.items){
            if(item == re){
                String message = String.format("expect a item not in %s but got %s", this.items, re);
                throw new ParsecException(s.index(), message);
            }
        }
        return re;
    }

    public NoneOf(E[] items){
        this.items = items;
    }
}
