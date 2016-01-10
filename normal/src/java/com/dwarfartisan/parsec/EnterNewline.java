package com.dwarfartisan.parsec;

import java.io.EOFException;

/**
 * Created by zhaonf on 16/1/10.
 */
public class EnterNewline extends Parsec<String, Character> {

    @Override
    public String parse(State<Character> s) throws EOFException, ParsecException {
        Parsec<String, Character> rn = new Try<String, Character>(
                new Ch('\n').over(new Ch('\r')).then(
                        new Return<String, Character>("\n\r")
                ));


        return rn.parse(s);
    }
}
