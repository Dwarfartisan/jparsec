package com.dwarfartisan.parsec;

import java.io.EOFException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mars Liu on 16/1/2.
 */
public class Many1Til<T, L, E> extends Parsec<List<T>, E> {
    private P<T, E> parser;
    private P<L, E> til;
    @Override
    public List<T> parse(State<E> s) throws EOFException, ParsecException {
        List<T> re = new ArrayList<T>();
        re.add(this.parser.parse(s));
        try{
            while (true) {
                re.add(this.parser.parse(s));
            }
        }catch (Exception e){
            this.til.parse(s);
            return re;
        }
    }
    public Many1Til(P<T, E> parser, P<L, E> til) {
        this.parser = new Try<T, E>(parser);
        this.til = til;
    }
}