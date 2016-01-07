package com.dwarfartisan.parsec;

import java.io.EOFException;

/**
 * Created by zhaonf on 16/1/6.
 */
public class Return<E> implements Parsec<E, E> {
    private E p;


    public Return(E item) {
        this.p = item;
    }

    @Override
    public E parse(State<E> s) throws EOFException, ParsecException {
        return this.p;
    }

}