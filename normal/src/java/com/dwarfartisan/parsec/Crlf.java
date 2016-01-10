package com.dwarfartisan.parsec;

import java.io.EOFException;

/**
 * Created by Mars Liu on 2016-01-10.
 */
public class Crlf extends Parsec<String, Character> {
    private Parsec<String, Character> paser = new Text("\n\r");

    @Override
    public String parse(State<Character> s) throws EOFException, ParsecException {
        return this.paser.parse(s);
    }
}
