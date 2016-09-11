package com.dwarfartisan.parsec;

import java.io.EOFException;

/**
 * Created by Mars Liu on 2016-01-03.
 * Ne 即 not equals ,它期待下个信息项与给定值不相等.
 */
public class Ne<E, Status, Tran> implements Parsec<E, E, Status, Tran> {
    private E item;

    @Override
    public E parse(State<E, Status, Tran> s) throws EOFException, ParsecException {
        E re = s.next();
        if (re==this.item) {
            String message = String.format("Expect a data not Equal %s", item);
            throw s.trap(message);
        }
        return re;
    }

    public Ne(E item){
        this.item = item;
    }
}
