package com.dwarfartisan.parsec;

import com.sun.tools.classfile.CharacterRangeTable_attribute;

import java.io.EOFException;

/**
 * Created by Mars Liu on 2016-01-08.
 */
public class Newline extends Parsec<String, Character> {
    @Override
    public String parse(State<Character> s) throws EOFException, ParsecException {
        Parsec<String, Character> r = new Try<String, Character>(new Ch('\r').then(new Return<String, Character>("\r")));
        Parsec<String, Character> n = new Try<String, Character>(new Ch('\r').then(new Return<String, Character>("\n")));
        Parsec<String, Character> rn = new Try<String, Character>(new Ch('\r').then(new Return<String, Character>("\r\n")));
        Parsec<String, Character> failed = new Try<String, Character>(new Parsec<String, Character>() {
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
        Parsec<String, Character> psc = new Either<String, Character>(r, n).or(rn).or(failed);
        return psc.parse(s);
    }
}
