package com.dwarfartisan.parsec;

/**
 * Created by Mars Liu on 2016-01-09.
 */
public abstract class Base {
    protected State<Character> newState(String data) {
        Character[] buffer   = new Character[data.length()];
        for (int i=0; i < data.length(); i++) {
            buffer[i] = data.charAt(i);
        }

        return new BasicState<Character>(buffer);
    }
}
