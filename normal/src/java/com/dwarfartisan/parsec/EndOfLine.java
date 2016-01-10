package com.dwarfartisan.parsec;

import java.io.EOFException;

/**
 * Created by zhaonf on 16/1/10.
 */
public class EndOfLine extends Parsec<String, Character> {

    @Override
    public String parse(State<Character> s) throws EOFException, ParsecException {
        new Newline().parse(s);
        try {
            new Try<Character, Character>(new Ch('\r')).parse(s);
            return "\n\r";
        } catch (EOFException e) {
            return "\n";
        } catch (ParsecException e){
            return "\n";
        }
    }
}
