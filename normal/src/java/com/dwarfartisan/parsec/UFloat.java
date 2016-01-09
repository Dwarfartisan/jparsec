package com.dwarfartisan.parsec;

import java.io.EOFException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mars Liu on 2016-01-08.
 */
public class UFloat extends Parsec<String, Character> {
    private Parsec<List<Character>, Character> parser = new Parsec<List<Character>, Character>() {
        @Override
        public List<Character> parse(State<Character> s) throws EOFException, ParsecException {
            Parsec<List<Character>, Character> numbers = new Many<Character, Character>(new Digit());
            List<Character> re = numbers.parse(s);
            if (re.isEmpty()){
                re.add('0');
            }
            re.add(new Ch('.').parse(s));
            re.add(new Digit().parse(s));
            re.addAll(numbers.parse(s));
            return re;
        }
    };

    @Override
    public String parse(State<Character> s) throws EOFException, ParsecException {
        List<Character> buffer = parser.parse(s);
        StringBuilder sb = new StringBuilder();
        for (Character c:buffer){
            sb.append(c);
        }
        return sb.toString();
    }
}
