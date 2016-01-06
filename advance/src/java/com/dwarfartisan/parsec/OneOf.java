package com.dwarfartisan.parsec;

import java.io.EOFException;
import java.util.Arrays;

/**
 * Created by Mars Liu on 2016-01-03.
 */
public class OneOf<E> implements Parsec<E, E> {
    private E[] items;
    @Override
    public E parse(State<E> s) throws EOFException, ParsecException {
        E data = s.next();

        if( Arrays.asList(this.items).contains(data) == true ){
            return data;
        }
//用下面循环慢了1毫秒
/*
        for (E item: this.items) {
            if (data == item){
                return data;
            }
        }
*/
        String message = String.format("Expect %s in %s", data, this.items);
        throw new ParsecException(s.index(), message);
    }
    public OneOf(E[] items){
        this.items = items;
    }

}
