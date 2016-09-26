package com.dwarfartisan.parsec;

import java.io.EOFException;

import static com.dwarfartisan.parsec.Txt.text;

/**
 * Created by Mars Liu on 2016-01-11.
 * Crlf 即 haskell parsec 的 crlf 算子,匹配 \r\n .
 */
public class Crlf<Status, Tran> implements Parsec<String, Character, Status, Tran> {
    Parsec<String, Character, Status, Tran> parser = text("\r\n");
    @Override
    public String parse(State<Character, Status, Tran> s)
            throws EOFException, ParsecException {
        return parser.parse(s);
    }
}
