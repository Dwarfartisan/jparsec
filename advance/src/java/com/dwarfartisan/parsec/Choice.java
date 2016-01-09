package com.dwarfartisan.parsec;

import java.io.EOFException;

/**
 * Created by Mars Liu on 2016-01-03.
 */
public class Choice<T, E> implements Parsec<T, E> {
    private Parsec<T, E>[] parsecs;

    @Override
    public T parse(State<E> s) throws EOFException, ParsecException {
        Exception err = null;
        int index = s.index();
        for (Parsec<T, E> psc : this.parsecs){
            try {
                return psc.parse(s);
            }catch (EOFException|ParsecException e){
                err = e;
                if(s.index()!=index){
                    throw e;
                }
            }
        }
        if(err == null){
            throw new ParsecException(s.index(), "Choice Error : All parsec parser failed.");
        } else {
            String message = String.format("Choice Error %s, stop at %d", err, s.index());
            throw new ParsecException(s.index(), message);
        }
    }

    @SafeVarargs
    public Choice(Parsec<T, E> ... parsecs) {
        this.parsecs = parsecs;
    }
}
