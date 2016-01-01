package com.tratao.dwarfartisan.parsec;

import java.io.EOFException;

/**
 * Created by Mars Liu on 16/1/1.
 */
public class Try<T, E> implements Parsec<T, E> {
    private Parsec<T, E> parser;
    public T parse(State<E> s) throws EOFException, ParsecException {
        int tran = s.begin();
        try {
            T re = this.parser.parse(s);
            s.commit(tran);
            return re;
        } catch (Exception e) {
            s.rollback(tran);
            throw e;
        }
    }
    public Try(Parsec<T, E> parser) {
        this.parser = parser;
    }
}
