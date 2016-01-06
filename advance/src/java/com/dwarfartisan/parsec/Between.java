package com.dwarfartisan.parsec;

import java.io.EOFException;

/**
 * Created by Mars Liu on 2016-01-03.
 */
public class Between<T, E, O, C> implements Parsec<T, E> {
    private Parsec<O, E> open;
    private Parsec<C, E> close;
    private Parsec<T, E> parsec;

    @Override
    public T parse(State<E> s) throws EOFException, ParsecException {
        open.parse(s);
        T re = parsec.parse(s);
        close.parse(s);
        return re;
    }

    public Between(Parsec<O, E> open, Parsec<C, E> close, Parsec<T, E> parsec) {
        this.open = open;
        this.close = close;
        this.parsec = parsec;
    }


    public class In {
        private Parsec<O, E> open;
        private Parsec<C, E> close;
        public In(Parsec<O, E> open, Parsec<C, E> close) {
            this.open = open;
            this.close = close;
        }
        public Parsec<T, E> pack(Parsec<T, E> parser) {
            return new Between<>(this.open, this.close, parser);
        }
    }
}
