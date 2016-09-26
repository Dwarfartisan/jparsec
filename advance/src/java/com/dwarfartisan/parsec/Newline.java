package com.dwarfartisan.parsec;

import java.io.EOFException;

import static com.dwarfartisan.parsec.Combinator.*;
import static com.dwarfartisan.parsec.Txt.crlf;
import static com.dwarfartisan.parsec.Txt.lf;

/**
 * Created by Mars Liu .
 * Newline 尝试匹配 \n 或 \r\n
 * -----------------
 */
public class Newline<Status, Tran> implements Parsec<String, Character, Status, Tran> {
    private Parsec<String, Character, Status, Tran> parser = choice(
            attempt(new Lf<Status, Tran>()).then(new Return<>("\r\n")), crlf());
    @Override
    public String parse(State<Character, Status, Tran> s)
            throws EOFException, ParsecException {
        return parser.parse(s);
    }
}
