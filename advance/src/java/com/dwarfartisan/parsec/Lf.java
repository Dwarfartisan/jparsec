package com.dwarfartisan.parsec;

import java.io.EOFException;

/**
 * Created by Mars Liu on 2016/9/26.
 * LF match \n
 */
public class Lf<Status, Tran> implements Parsec<Character, Character, Status, Tran>{
    Parsec<Character, Character, Status, Tran> parser = new Ch<>('\n');

    @Override
    public Character parse(State<Character, Status, Tran> s) throws EOFException, ParsecException {
        return parser.parse(s);
    }
}
