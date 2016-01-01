package com.tratao.dwarfartisan.parsec;

import java.io.EOFException;
import java.util.Arrays;

/**
 * Created by Mars Liu on 16/1/1.
 */
public class NoneOf<T> implements Parsec<T, T> {
    private T[] items;
    public T parse(State<T> s) throws EOFException, ParsecException {
        T re;
        re = s.next();
        for (T item : this.items){
            if (re.equals(item)) {
                String message = String.format("Expect a item none of %s, but got %s", Arrays.toString(this.items), re);
                throw new ParsecException(s.index(), message);
            }
        }
        return re;
    }
    public NoneOf(T[] items) {
        this.items = items;
    }
}
