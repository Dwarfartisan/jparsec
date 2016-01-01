package com.tratao.dwarfartisan.parsec;

import java.io.EOFException;
import java.util.ArrayList;

/**
 * Created by Mars Liu on 16/1/2.
 */
public class Many1Til<T, L, E> implements Parsec<ArrayList<T>, E> {
    private Parsec<T, E> parser;
    private Parsec<L, E> til;
    @Override
    public ArrayList<T> parse(State<E> s) throws EOFException, ParsecException {
        ArrayList<T> re = new ArrayList<>();
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
    public Many1Til(Parsec<T, E> parser, Parsec<L, E> til) {
        this.parser = new Try<T, E>(parser);
        this.til = til;
    }
}