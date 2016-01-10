package com.dwarfartisan.parsec;

import java.io.EOFException;

/**
 * Created by Mars Liu on 2016-01-11.
 * Crlf 即 haskell parsec 的 crlf 算子,匹配 \n\r .
 */
public class Crlf implements Parsec<String, Character> {
    @Override
    public String parse(State<Character> s) throws EOFException, ParsecException {
        new Newline().parse(s);
        new Ch('\r').parse(s);
        return "\n\r";
    }
}
