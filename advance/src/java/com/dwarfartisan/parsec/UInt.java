package com.dwarfartisan.parsec;

import java.io.EOFException;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * Created by Mars Liu on 2016-01-07.
 */
public class UInt implements Parsec<String, Character> {
    private Parsec<List<Character>, Character> parser = new Many1<>(new Digit());
    @Override
    public String parse(State<Character> s) throws EOFException, ParsecException {
        List<Character> buffer = parser.parse(s);
        StringBuilder sb = new StringBuilder();
        buffer.stream().forEach(sb::append);
        return sb.toString();
    }
}
