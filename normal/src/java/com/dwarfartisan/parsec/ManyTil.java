package com.dwarfartisan.parsec;

import java.io.EOFException;
import java.util.ArrayList;

/**
 * Created by Mars Liu on 16/1/2.
 */
public class ManyTil<T, L, E> extends Parsec<ArrayList<T>, E> {
    private P<T, E> parser;
    private P<L, E> til;
    @Override
    public ArrayList<T> parse(State<E> s) throws EOFException, ParsecException {
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
    public ManyTil(P<T, E> parser, P<L, E> til) {
        this.parser = new Try<T, E>(parser);
        this.til = til;
    }
}
