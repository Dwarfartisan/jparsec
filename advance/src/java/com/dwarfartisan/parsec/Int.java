package com.dwarfartisan.parsec;

import java.io.EOFException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mars Liu on 2016-01-07.
 * Int 算子尝试将后续的信息项组成一个整数,如果获得的信息不足以组成一个整数,抛出异常.
 */
public class Int<Status, Tran> implements Parsec<String, Character, Status, Tran> {
    private Parsec<List<Character>, Character, Status, Tran> parser = new Ch<Status, Tran>('-').then(s -> {
        List<Character> re = new ArrayList<>('-');
        re.addAll(new Many1<>(new Digit<Status, Tran>()).parse(s));
        return re;
    });

    @Override
    public String parse(State<Character, Status, Tran> s) throws EOFException, ParsecException {
        List<Character> buffer = parser.parse(s);
        StringBuilder sb = new StringBuilder();
        buffer.forEach(sb::append);
        return sb.toString();
    }
}
