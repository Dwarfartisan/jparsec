package com.dwarfartisan.parsec;

import java.util.List;

/**
 * Created by Mars Liu on 16/9/13.
 * JoinText is a binder. It join Character List to String.
 */
public class JoinText<E, Status, Tran> implements Binder<List<Character>, String, E, Status, Tran> {
    @Override
    public Parsec<String, E, Status, Tran> bind(List<Character> value) {
        StringBuilder sb = new StringBuilder();
        value.forEach(sb::append);
        String re = sb.toString();
        return state -> re;
    }
}
