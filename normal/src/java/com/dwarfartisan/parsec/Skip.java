package com.dwarfartisan.parsec;

import java.io.EOFException;

/**
 * Created by Mars Liu on 2016-01-08.
 */
public class Skip<T, E> extends Parsec<T, E> {
    private Parsec<T, E> parser;

    @Override
    public T parse(State<E> s) throws EOFException, ParsecException {
        try {
            while (true) {
                parser.parse(s);
            }
        }catch (EOFException e) {
            return null;
        }catch (ParsecException e) {
            return null;
        }
    }

    public Skip(Parsec<T, E> psc) {
        this.parser = new Try<T, E>(psc);
    }
}
