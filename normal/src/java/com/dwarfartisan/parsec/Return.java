package com.dwarfartisan.parsec;

import java.io.EOFException;

/**
 * Created by Mars Liu on 2016-01-08.
 */
public class Return<T, E> extends Parsec<T, E> {
    private T item;

    @Override
    public T parse(State<E> s) throws EOFException, ParsecException {
        return item;
    }
    public Return(T item){
        this.item = item;
    }
}