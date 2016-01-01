package com.tratao.dwarfartisan.parsec;

import java.io.EOFException;

/**
 * Created by Mars Liu on 16/1/1.
 */
public class Between<T, E, O, C> implements Parsec<T, E> {
    private Parsec<O, E> open;
    private Parsec<C, E> close;
    private Parsec<T, E> parser;

    @Override
    public T parse(State<E> s) throws EOFException, ParsecException {
        open.parse(s);
        T re = parser.parse(s);
        close.parse(s);
        return re;
    }

    public Between(Parsec<O, E> open, Parsec<C, E> close, Parsec<T, E> parser) {
        this.open = open;
        this.close = close;
        this.parser = parser;
    }

    public class Curry {
        private Parsec<O, E> open;
        private Parsec<C, E> close;
        public Curry(Parsec<O, E> open, Parsec<C, E> close) {
            this.open = open;
            this.close = close;
        }
        public Parsec<T, E> Pack(Parsec<T, E> parser) {
            return new Between(this.open, this.close, parser);
        }
    }
}
