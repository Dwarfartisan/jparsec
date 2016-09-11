package com.dwarfartisan.parsec;

import java.io.EOFException;
import java.util.List;

/**
 * Created by Mars Liu on 2016-01-07.
 * UInt 尝试将后续信息流解析成一个表示无符号整数的字符串,如果匹配失败就抛出异常.
 */
public class UInt<Status, Tran> implements Parsec<String, Character, Status, Tran> {
    private Parsec<List<Character>, Character, Status, Tran> parser = new Many1<>(new Digit<Status, Tran>());
    @Override
    public String parse(State<Character, Status, Tran> s) throws EOFException, ParsecException {
        List<Character> buffer = parser.parse(s);
        StringBuilder sb = new StringBuilder();
        buffer.forEach(sb::append);
        return sb.toString();
    }
}
