package com.dwarfartisan.parsec;

import java.io.EOFException;

/**
 * Created by Mars Liu on 2016-01-02.
 */
public abstract class Parsec<T, E> implements P<T, E> {
    @Override
    public abstract T parse(State<E> s) throws EOFException, ParsecException;

    public <C> P<C, E> bind(final Binder<T, C, E> binder) {
        final Parsec<T, E> psc = this;
        return new Parsec<C, E>() {
            @Override
            public C parse(State<E> s) throws EOFException, ParsecException {
                T value = psc.parse(s);
                return binder.bind(value).parse(s);
            }
        };
    }

    public <C> P<C, E> then(final Parsec<C, E> parsec) throws EOFException, ParsecException {
        final Parsec<T, E> psc = this;
        return new Parsec<C, E>() {
            @Override
            public C parse(State<E> s) throws EOFException, ParsecException {
                psc.parse(s);
                return parsec.parse(s);
            }
        };
    }

    public <C> P<T, E> over(final Parsec<C, E> parsec) throws EOFException, ParsecException {
        final Parsec<T, E> psc = this;
        return new Parsec<T, E>() {
            @Override
            public T parse(State<E> s) throws EOFException, ParsecException {
                T value = psc.parse(s);
                parsec.parse(s);
                return value;
            }
        };
    }
}
