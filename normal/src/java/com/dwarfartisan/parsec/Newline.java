package com.dwarfartisan.parsec;

import com.sun.tools.classfile.CharacterRangeTable_attribute;

import java.io.EOFException;

/**
 * Created by Mars Liu on 2016-01-08.
 */
public class Newline extends Parsec<String, Character> {
    @Override
    public String parse(State<Character> s) throws EOFException, ParsecException {
        Parsec<String, Character> r = new Try<String, Character>(
                new Ch('\r').then(
                        new Return<String, Character>("\n")
        ));


        return r.parse(s);
    }
}
