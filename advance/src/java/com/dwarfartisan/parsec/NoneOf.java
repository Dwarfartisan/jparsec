package com.dwarfartisan.parsec;

import java.io.EOFException;
import java.util.Arrays;

/**
 * Created by Mars Liu on 2016-01-03.
 * NoneOf 即 none of ,它期待得到的信息项与给定的任何项都不匹配,否则返回错误.
 */
public class NoneOf<E> implements Parsec<E, E> {
    private E[] items;

    @Override
    public E parse(State<E> s) throws EOFException, ParsecException {
        E re = s.next();
        for (E item : this.items){
            if(item == re){
                String message = String.format("expect a item not in %s but got %s", Arrays.toString(this.items), re);
                throw s.trap(message);
            }
        }
        return re;
    }

    public NoneOf(E[] items){
        this.items = items;
    }
}
