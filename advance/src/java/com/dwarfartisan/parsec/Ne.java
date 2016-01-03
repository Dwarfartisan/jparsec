package com.dwarfartisan.parsec;

import java.io.EOFException;

/**
 * Created by Mars Liu on 2016-01-03.
 */
public class Ne<E> implements Parsec<E, E> {
    private E item;

    @Override
    public E parse(State<E> s) throws EOFException, ParsecException {
        E re = s.next();
        if (re==this.item) {
            String message = String.format("Expect a data not Equal %s", item);
            throw new ParsecException(s.index(), message);
        }
        return re;
    }

    public Ne(E item){
        this.item = item;
    }
}
