package com.dwarfartisan.parsec;

import java.io.EOFException;

/**
 * Created by Mars Liu on 2016-01-07.
 */
public class Newline implements Parsec<String, Character> {
    @Override
    public String parse(State<Character> s) throws EOFException, ParsecException {
        Parsec<String, Character> r = new Try<>(new Ch('\r').then(new Return<>("\r")));
        Parsec<String, Character> n = new Try<>(new Ch('\r').then(new Return<>("\n")));
        Parsec<String, Character> rn = new Try<>(new Ch('\r').then(new Return<>("\r\n")));
        Parsec<String, Character> failed = new Try<>(new Parsec<String, Character>() {
            @Override
            public String parse(State<Character> s) throws EOFException, ParsecException {
                try{
                    Character next = s.next();
                    String message = String.format("Expect %c is newline.", next);
                    throw new ParsecException(s.index(), message);
                } catch (EOFException e) {
                    String message = String.format("Expect newline at %d but eof.", s.index());
                    throw new ParsecException(s.index(), message);
                }
            }
        });
        return new Choice<>(r, n, rn, failed).parse(s);
    }
}
