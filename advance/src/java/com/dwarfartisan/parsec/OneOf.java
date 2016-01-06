package com.dwarfartisan.parsec;

import java.io.EOFException;

/**
 * Created by Mars Liu on 2016-01-03.
 */
public class OneOf<E> implements Parsec<E, E> {
    private E[] items;
    @Override
    public E parse(State<E> s) throws EOFException, ParsecException {
        E data = s.next();
        for (E item: this.items) {
            if (data == item){
                return data;
            }
        }
        String message = String.format("Expect %s in %s", data, this.items);
        throw new ParsecException(s.index(), message);
    }
    public OneOf(E[] items){
        this.items = items;
    }
}
