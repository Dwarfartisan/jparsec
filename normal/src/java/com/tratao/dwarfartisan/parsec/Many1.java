package com.tratao.dwarfartisan.parsec;

import java.io.EOFException;
import java.util.ArrayList;

/**
 * Created by Mars Liu on 16/1/1.
 */
public class Many1<T, E> implements Parsec<ArrayList<T>, E> {
    private Parsec<T, E> parser;
    @Override
    public ArrayList<T> parse(State<E> s) throws EOFException, ParsecException {
        ArrayList<T> re = new ArrayList<>();
        re.add(this.parser.parse(s));
        try{
            while (true) {
                re.add(this.parser.parse(s));
            }
        }catch (Exception e){
            return re;
        }
    }
    public Many1(Parsec<T, E> parser) {
        this.parser = new Try<T, E>(parser);
    }
}
