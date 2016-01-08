package com.dwarfartisan.parsec;

import java.io.EOFException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mars Liu on 16/1/2.
 */
public class ManyTil<T, L, E> extends Parsec<List<T>, E> {
    private Parsec<T, E> parser;
    private Parsec<L, E> til;
    @Override
    public List<T> parse(State<E> s) throws EOFException, ParsecException {
        ArrayList<T> re = new ArrayList<T>();
        try{
            while (true) {
                re.add(this.parser.parse(s));
            }
        }catch (Exception e){
            this.til.parse(s);
            return re;
        }
    }
    public ManyTil(Parsec<T, E> parser, Parsec<L, E> til) {
        this.parser = new Try<T, E>(parser);
        this.til = til;
    }
}
