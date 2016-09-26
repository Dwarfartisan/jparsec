package com.dwarfartisan.parsec;

/**
 * Created by Mars Liu on 2016/9/26.
 * Match a char and not equal value.
 */
public class NCh<Status, Tran> extends Ne<Character, Status, Tran> implements Parsec<Character, Character, Status, Tran> {
    public NCh(Character item) {
        super(item);
    }
}
