package com.dwarfartisan.parsec;

import java.io.EOFException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mars Liu on 2016-01-03.
 */
public class Many1<T, E> implements Parsec<List<T>, E> {
    private Parsec<T, E> parsec;

    @Override
    public List<T> parse(State<E> s) throws EOFException, ParsecException {
        List<T> re = new ArrayList<T>();
        re.add(this.parsec.parse(s));
        try{
            while (true){
                re.add(this.parsec.parse(s));
            }
        } catch (Exception e){
            return re;
        }
    }

    public Many1(Parsec<T, E> parsec){
        this.parsec = parsec;
    }
}
