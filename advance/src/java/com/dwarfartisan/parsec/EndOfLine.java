package com.dwarfartisan.parsec;

import java.io.EOFException;

/**
 * Created by zhaonf on 16/1/10.
 * EndOfLine 尝试匹配 \n\r 或 \n
 */
public class EndOfLine<Status, Tran> implements Parsec<String, Character, Status, Tran> {
    @Override
    public String parse(State<Character, Status, Tran> s)
            throws EOFException, ParsecException {
        new Ch<Status, Tran>('\n').parse(s);
        try{
            new Try<>(new Ch<Status, Tran>('\r')).parse(s);
            return "\n\r";
        } catch (EOFException|ParsecException e) {
            return "\n";
        }
    }
}
