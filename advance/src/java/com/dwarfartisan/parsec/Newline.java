package com.dwarfartisan.parsec;

import java.io.EOFException;

/**
 * Created by Mars Liu .
 * Newline 尝试匹配换\n
 * -----------------
 */
public class Newline<Status, Tran> implements Parsec<Character, Character, Status, Tran> {
    private Parsec<Character, Character, Status, Tran> parser = new Ch<>('\n');
    @Override
    public Character parse(State<Character, Status, Tran> s)
            throws EOFException, ParsecException {
        return parser.parse(s);
    }
}
