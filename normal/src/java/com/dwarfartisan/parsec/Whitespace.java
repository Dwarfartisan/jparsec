package com.dwarfartisan.parsec;

import java.io.EOFException;

/**
 * Created by Mars Liu on 2016-01-08.
 */
public class Whitespace extends Parsec<Character, Character>{
    @Override
    public Character parse(State<Character> s) throws EOFException, ParsecException {
        Character re = s.next();
        if (Character.isWhitespace(re)) {
            return re;
        } else {
            String message = String.format("Expect %c is whitespace.", re);
            throw new ParsecException(s.index(), message);
        }
    }
}
