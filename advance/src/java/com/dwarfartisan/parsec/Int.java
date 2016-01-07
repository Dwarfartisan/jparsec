package com.dwarfartisan.parsec;

import java.io.EOFException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mars Liu on 2016-01-07.
 */
public class Int implements Parsec<String, Character> {
    private Parsec<List<Character>, Character> parser = new Ch('-').then(new Parsec<List<Character>, Character>(){
        public List<Character> parse(State<Character> s) throws EOFException, ParsecException{
            List<Character> re = new ArrayList<Character>('-');
            re.addAll(new Many1<>(new Digit()).parse(s));
            return re;
        }
    });

    @Override
    public String parse(State<Character> s) throws EOFException, ParsecException {
        List<Character> buffer = parser.parse(s);
        StringBuilder sb = new StringBuilder();
        for (Character ch: buffer) {
            sb.append(ch);
        }
        return sb.toString();
    }
}
