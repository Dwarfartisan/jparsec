package com.dwarfartisan.parsec;

import java.io.EOFException;

/**
 * Created by zhaonf on 16/1/10.
 */
public class Enter implements Parsec<String,Character> {

    @Override
    public String parse(State<Character> s) throws EOFException, ParsecException {
        Parsec<String, Character> n = new Try<String, Character>(
                new Ch('\n').then(
                        new Return<String, Character>("\n")
                ));
        return n.parse(s);
    }
}
