package com.dwarfartisan.parsec;

import java.io.EOFException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mars Liu on 2016-01-03.
 * Many1 匹配给定算子 1 到多次.
 */
public class Many1<T, E> implements Parsec<List<T>, E> {
    private Parsec<T, E> parsec;

    @Override
    public List<T> parse(State<E> s) throws EOFException, ParsecException {
        List<T> re = new ArrayList<>();
        re.add(this.parsec.parse(s));
        try{
            while (true){
                re.add(this.parsec.parse(s));
            }
        } catch (EOFException|ParsecException e){
            return re;
        }
    }

    public Many1(Parsec<T, E> parsec){
        this.parsec = parsec;
    }
}
