package com.dwarfartisan.parsec;

import java.awt.*;
import java.io.CharArrayReader;
import java.io.EOFException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mars Liu on 2016-01-08.
 */
public class Int extends Parsec<String, Character> {
    private Parsec<List<Character>, Character> parser = new Parsec<List<Character>, Character>() {
        @Override
        public List<Character> parse(State<Character> s) throws EOFException, ParsecException {
            Parsec<List<Character>, Character> ne = (Parsec<List<Character>, Character>) new Try<Character, Character>(new Ch('-'))
                    .then(new Return<List<Character>, Character>(new ArrayList<Character>('-')));
            Parsec<List<Character>, Character> signed = new Either<List<Character>, Character>(ne,
                    new Return<List<Character>, Character>(new ArrayList<Character>()));
            List<Character> re = signed.parse(s);
            re.addAll(new Many1<Character, Character>(new Digit()).parse(s));
            return re;
        }
    };

    @Override
    public String parse(State<Character> s) throws EOFException, ParsecException {
        List<Character> buffer = parser.parse(s);
        StringBuilder sb = new StringBuilder();
        for (Character ch : buffer) {
            sb.append(ch);
        }
        return sb.toString();
    }
}