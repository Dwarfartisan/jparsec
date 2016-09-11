package com.dwarfartisan.parsec;

import java.io.EOFException;
import java.util.List;

import static java.util.stream.Collectors.joining;

/**
 * Created by Mars Liu on 2016-01-03.
 * NoneOf 即 none of ,它期待得到的信息项与给定的任何项都不匹配,否则返回错误.
 */
public class NoneOf<E, Status, Tran> implements Parsec<E, E, Status, Tran> {
    private List<E> items;

    @Override
    public E parse(State<E, Status, Tran> s) throws EOFException, ParsecException {
        E re = s.next();
        for (E item : this.items){
            if(item == re){
                String message = String.format("expect a item not in [%s] but got %s",
                        this.items.stream().map(x->x.toString()).collect(joining()), re);
                throw s.trap(message);
            }
        }
        return re;
    }

    public NoneOf(List<E> items){
        this.items = items;
    }
}
