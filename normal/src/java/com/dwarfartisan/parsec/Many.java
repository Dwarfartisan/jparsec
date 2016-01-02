package com.dwarfartisan.parsec;

import java.io.EOFException;
import java.util.ArrayList;

/**
 * Created by Mars Liu on 16/1/1.
 */
public class Many<T, E> extends Parsec<ArrayList<T>, E> {
    private P<T, E> parser;
    @Override
    public ArrayList<T> parse(State<E> s) throws EOFException, ParsecException {
        ArrayList<T> re = new ArrayList<T>();
        try{
            while (true) {
                re.add(this.parser.parse(s));
            }
        }catch (Exception e){
            return re;
        }
    }
    public Many(P<T, E> parser) {
        this.parser = new Try<T, E>(parser);
    }
}
