package com.dwarfartisan.parsec;

import java.io.EOFException;

/**
 * Created by Mars Liu on 16/1/1.
 */
public class Ne<T> extends Parsec<T, T> {
    private T item;
    public T parse(State<T> s) throws EOFException, ParsecException {
        T re = s.next();
        if (!(re == item)) {
            return re;
        } else {
            String message = String.format("Expect a item not equals to %s, but got %s", this.item, re);
            throw new ParsecException(s.index(), message);
        }
    }
    public Ne(T item) {
        this.item = item;
    }
}
