package com.dwarfartisan.parsec;

import jdk.nashorn.internal.ir.LoopNode;

import java.io.EOFException;

/**
 * Created by Mars Liu on 2016-01-07.
 */
public class Skip1<T, E> implements Parsec<T, E> {
    private Parsec<T, E> psc;

    @Override
    public T parse(State<E> s) throws EOFException, ParsecException {
        psc.parse(s);
        int tran = s.index();
        try {
            while (true) {
                tran = s.begin();
                psc.parse(s);
                s.commit(tran);
            }
        }catch (EOFException|ParsecException e){
            s.rollback(tran);
        }
        return null;
    }

    public Skip1(Parsec<T, E> psc) {
        this.psc = psc;
    }
}