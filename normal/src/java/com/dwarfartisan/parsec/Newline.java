package com.dwarfartisan.parsec;

import java.io.EOFException;

/**
 * Created by zhaonf on 16/1/10.
 */
public class Newline extends Parsec<String,Character> {
    private Parsec<Character, Character> parser = new Ch('\n');
    @Override
    public String parse(State<Character> s) throws EOFException, ParsecException {
        this.parser.parse(s);
        return "\n";
    }
}
