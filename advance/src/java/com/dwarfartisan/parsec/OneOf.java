package com.dwarfartisan.parsec;

import java.io.EOFException;
import java.util.Arrays;

/**
 * Created by Mars Liu on 2016-01-03.
 * OneOf 即 one of ,给定项中任何一个匹配成功即视为成功,否则抛出错误.
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
        String message = String.format("Expect %s in %s", data, Arrays.toString(this.items));
        throw new ParsecException(s.index(), message);
    }
    public OneOf(E[] items){
        this.items = items;
    }
}
