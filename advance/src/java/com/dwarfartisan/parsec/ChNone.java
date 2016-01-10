package com.dwarfartisan.parsec;

import java.io.EOFException;

/**
 * Created by Mars Liu on 2016-01-10.
 * ChNone 即 char none of,是为 Character 特化的 none of
 */
public class ChNone implements Parsec<Character, Character> {
    private NoneOf<Character> noneOf;

    @Override
    public Character parse(State<Character> s) throws EOFException, ParsecException {
        return noneOf.parse(s);
    }

    public ChNone(String data){
        char[] buffer = data.toCharArray();
        Character[] items = new Character[buffer.length];
        for (int i = 0; i<buffer.length; i++){
            items[i] = buffer[i];
        }
        this.noneOf = new NoneOf<>(items);
    }
}
