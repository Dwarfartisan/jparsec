package com.dwarfartisan.parsec;

import sun.reflect.annotation.ExceptionProxy;

import java.io.EOFException;

/**
 * Created by Mars Liu on 2016-01-03.
 */
public class Try<T, E> implements Parsec<T, E> {
    private Parsec<T, E> parsec;

    @Override
    public T parse(State<E> s) throws EOFException, ParsecException {
        int tran = s.begin();
        try{
            T re = this.parsec.parse(s);
            s.commit(tran);
            return re;
        } catch (Exception e) {
            s.rollback(tran);
            throw e;
        }
    }

    public Try(Parsec<T, E> parsec){
        this.parsec = parsec;
    }
}
