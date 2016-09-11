package com.dwarfartisan.parsec;

import java.io.EOFException;

/**
 * Created by Mars Liu on 2016-01-02.
 * Parsec 是 parsec 算子的行为规范协议.
 */
@FunctionalInterface
public interface Parsec<T, E, Status, Tran> {
    T parse(State<E, Status, Tran> s)
            throws EOFException, ParsecException;

    default <C> Parsec<C, E, Status, Tran> bind(Binder<T, C, E, Status, Tran> binder) {
        return (s) -> {
            T value = Parsec.this.parse(s);
            return binder.bind(value).parse(s);
        };
    }

    default <C> Parsec<C, E, Status, Tran> then(Parsec<C, E, Status, Tran> parsec) {
        return (s) -> {
            Parsec.this.parse(s);
            return parsec.parse(s);
        };
    }

    default <C> Parsec<T, E, Status, Tran> over(Parsec<C, E, Status, Tran> parsec) {
        return s -> {
            T value = Parsec.this.parse(s);
            parsec.parse(s);
            return value;
        };
    }
}
