package com.dwarfartisan.parsec;

import com.dwarfartisan.parsec.OneOf;
import com.dwarfartisan.parsec.Parsec;
import com.dwarfartisan.parsec.ParsecException;
import com.dwarfartisan.parsec.State;

import java.io.EOFException;

/**
 * Created by Mars Liu on 2016-01-10.
 * ChIn 即 char in ,是为 Character 特化的 one of
 */
public class ChIn implements Parsec<Character, Character> {
    private OneOf<Character> oneOf;

    @Override
    public Character parse(State<Character> s) throws EOFException, ParsecException {
        return oneOf.parse(s);
    }

    public ChIn(String data){
        char[] buffer = data.toCharArray();
        Character[] items = new Character[buffer.length];
        for (int i = 0; i<buffer.length; i++){
            items[i] = buffer[i];
        }
        this.oneOf = new OneOf<>(items);
    }
}
