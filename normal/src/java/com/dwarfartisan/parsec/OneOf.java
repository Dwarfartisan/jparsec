package com.dwarfartisan.parsec;

import java.io.EOFException;
import java.util.Arrays;

/**
 * Created by Mars Liu on 16/1/1.
 */

public class OneOf<T> extends Parsec<T, T> {
    private T[] items;
    public T parse(State<T> s) throws EOFException, ParsecException {
        T re;
        re = s.next();
        for (T item : this.items){
            if (re.equals(item)) {
                return re;
            }
        }
        String message = String.format("Expect a item in %s, but got %s", Arrays.toString(this.items), re);
        throw new ParsecException(s.index(), message);
    }
    public OneOf(T[] items) {
        this.items = items;
    }
}
