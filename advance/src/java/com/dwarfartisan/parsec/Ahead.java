package com.dwarfartisan.parsec;

import java.io.EOFException;

/**
 * Created by Mars Liu on 16/9/15.
 * Ahead look forward state and try to match parser.
 * Ahead return the parser data or fail and rollback state whatever
 */
public class Ahead<T, E, Status, Tran> implements Parsec<T, E, Status, Tran> {
    Parsec<T, E, Status, Tran> parser;

    @Override
    public T parse(State<E, Status, Tran> s) throws EOFException, ParsecException {
        Tran tran = s.begin();
        try {
            return parser.parse(s);
        }  finally {
            s.rollback(tran);
        }
    }

    public Ahead(Parsec<T, E, Status, Tran> parser){
        this.parser = parser;
    }
}
