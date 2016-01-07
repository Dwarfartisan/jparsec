package com.dwarfartisan.parsec;

import java.io.EOFException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mars Liu on 2016-01-07.
 */
public class UFloat implements Parsec<String, Character> {
//    private Parsec<List<Character>, Character> parser = new Many<>(new Digit()).over(new Ch('.')).bind(
//            new Binder<List<Character>, List<Character>, Character>() {
//        @Override
//        public Parsec<List<Character>, Character> bind(List<Character> value) {
//            return new Parsec<List<Character>, Character>() {
//                @Override
//                public List<Character> parse(State<Character> s) throws EOFException, ParsecException {
//                    value.add('.');
//                    value.addAll(new Many1<>(new Digit()).parse(s));
//                    return value;
//                }
//            };
//        }
//    });
    private Parsec<List<Character>, Character> parser = new Parsec<List<Character>, Character>() {
        @Override
        public List<Character> parse(State<Character> s) throws EOFException, ParsecException {
            Parsec<List<Character>, Character> body = new Many<>(new Digit());
            List<Character> number = new ArrayList<>(body.parse(s));
            number.add(new Ch('.').parse(s));
            number.addAll(body.parse(s));
            return number;
        }
    };
    @Override
    public String parse(State<Character> s) throws EOFException, ParsecException {
        List<Character> buffer = parser.parse(s);
        StringBuilder sb = new StringBuilder();
        buffer.stream().forEach(sb::append);
        return sb.toString();
    }
}
