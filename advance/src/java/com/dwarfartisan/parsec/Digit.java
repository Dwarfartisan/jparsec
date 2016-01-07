package com.dwarfartisan.parsec;

import java.io.EOFException;

/**
 * Created by Mars Liu on 2016-01-07.
 */
public class Digit implements Parsec<Character, Character> {
    @Override
    public Character parse(State<Character> s) throws EOFException, ParsecException {
        Character re = s.next();
        if (Character.isDigit(re)) {
            return re;
        } else {
            String message = String.format("Expect %c is digit.", re);
            throw new ParsecException(s.index(), message);
        }
    }
}
