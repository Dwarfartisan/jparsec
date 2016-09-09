package com.dwarfartisan.parsec;

import java.io.EOFException;

/**
 * Created by march on 16/9/9.
 * Find 算子跳过不匹配的内容，直到匹配成功或者 eof 。
 */
public class Find<T, E> implements Parsec<T, E> {
    private  One<E> one;
    private  Parsec<T, E> parser;
    @Override
    public T parse(State<E> s) throws EOFException {
        while (true) {
            int tran = s.begin();
            try {
                T re = parser.parse(s);
                s.commit(tran);
                return re;
            } catch (ParsecException e) {
                s.rollback(tran);
                one.parse(s);
            }
        }
    }

    public Find(Parsec<T, E> parser) {
        this.parser = parser;
        this.one = new One<E>();
    }
}
