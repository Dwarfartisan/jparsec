package com.dwarfartisan.parsec;

import java.io.EOFException;

/**
 * Created by Mars Liu on 16/1/1.
 */
public class Between<T, E, O, C>  extends Parsec<T, E> {
    private P<O, E> open;
    private P<C, E> close;
    private P<T, E> parser;

    @Override
    public T parse(State<E> s) throws EOFException, ParsecException {
        open.parse(s);
        T re = parser.parse(s);
        close.parse(s);
        return re;
    }

    public Between(P<O, E> open, P<C, E> close, P<T, E> parser) {
        this.open = open;
        this.close = close;
        this.parser = parser;
    }

    public class In {
        private P<O, E> open;
        private P<C, E> close;
        public In(P<O, E> open, P<C, E> close) {
            this.open = open;
            this.close = close;
        }
        public P<T, E> pack(P<T, E> parser) {
            return new Between(this.open, this.close, parser);
        }
    }
}
