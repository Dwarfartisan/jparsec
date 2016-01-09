package com.dwarfartisan.parsec;

import java.io.EOFException;
import java.util.List;

/**
 * Created by Mars Liu on 2016-01-02.
 */
@FunctionalInterface
public interface Parsec<T, E> {
    T parse(State<E> s)throws EOFException, ParsecException;

    default <C> Parsec<C, E> bind(Binder<T, C, E> binder) {
        Parsec<T, E> psc = this;
        return new Parsec<C, E>() {
            @Override
            public C parse(State<E> s) throws EOFException, ParsecException {
                T value = psc.parse(s);
                return binder.bind(value).parse(s);
            }
        };
    }

    default <C> Parsec<C, E> then(Parsec<C, E> parsec){
        Parsec<T, E> psc = this;
        return new Parsec<C, E>() {
            @Override
            public C parse(State<E> s) throws EOFException, ParsecException {
                psc.parse(s);
                return parsec.parse(s);
            }
        };
    }

    default <C> Parsec<T, E> over(Parsec<C, E> parsec){
        Parsec<T, E> psc = this;
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
