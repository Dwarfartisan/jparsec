package com.dwarfartisan.parsec;

import java.io.EOFException;

/**
 * Created by Mars Liu on 2016-01-07.
 * Return 不改变 state ,它直接返回预设值.
 */
public class Return<T, E> implements Parsec<T, E> {
    private T item;

    @Override
    public T parse(State<E> s) throws EOFException, ParsecException {
        return item;
    }
    public Return(T item){
        this.item = item;
    }
}
