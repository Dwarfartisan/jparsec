package com.dwarfartisan.parsec;

import java.io.EOFException;

/**
 * Created by Mars Liu on 16/1/1.
 */
public class Eof<T> extends Parsec<Object, T> {
    @Override
    public Object parse(State<T> s) throws ParsecException {
        try{
            T re = s.next();
            throw new ParsecException(s.index(), "Expect eof but "+re.toString());
        } catch (EOFException e) {
            return null;
        }
    }
}
