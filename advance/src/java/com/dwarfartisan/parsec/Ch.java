package com.dwarfartisan.parsec;

import java.io.CharArrayReader;
import java.io.EOFException;

/**
 * Created by Mars Liu on 2016-01-07.
 */
public class Ch extends Eq<Character> implements Parsec<Character, Character>{
    public Ch(Character chr) {
        super(chr);
    }
};
