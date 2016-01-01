package com.tratao.dwarfartisan.parsec;

import java.io.EOFException;
import java.util.ArrayList;

/**
 * Created by Mars Liu on 16/1/1.
 */
public class SepBy<T, S, E> implements Parsec<ArrayList<T>, E> {
    private Parsec<S, E> by;
    private Parsec<T, E> p;
    @Override
    public ArrayList<T> parse(State<E> s) throws EOFException, ParsecException {
        ArrayList<T> re = new ArrayList<>();
        try {
            re.add(this.p.parse(s));
            while (true) {
                this.by.parse(s);
                re.add(this.p.parse(s));
            }
        } catch (Exception e) {
            return re;
        }
    }

    public SepBy(Parsec<T, E> p, Parsec<S, E> by) {
        this.by = new Try(by);
        this.p = new Try(p);
    }
}
