package com.dwarfartisan.parsec;

import java.io.EOFException;
import java.util.List;

/**
 * Created by Mars Liu on 2016-01-08.
 */
public class UInt extends Parsec<String, Character> {
    private Parsec<List<Character>, Character> parser = new Many1<Character, Character>(new Digit());
    @Override
    public String parse(State<Character> s) throws EOFException, ParsecException {
        List<Character> buffer = parser.parse(s);
        StringBuilder sb = new StringBuilder();
        for (Character ch : buffer){
            sb.append(ch);
        }
        return sb.toString();
    }
}
