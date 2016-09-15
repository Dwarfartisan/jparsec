package com.dwarfartisan.parsec;

import java.io.EOFException;

/**
 * Created by Mars Liu on 16/9/15.
 * Behind look forward state and try to match parser.
 * Behind return the parser data or fail and rollback state whatever
 */
public class Behind<T, E, Status, Tran> implements Parsec<T, E, Status, Tran> {
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

    public Behind(Parsec<T, E, Status, Tran> parser){
        this.parser = parser;
    }
}
