package com.dwarfartisan.parsec;

import java.io.EOFException;

/**
 * Created by Mars Liu on 2016-01-03.
 * Try 尝试执行给定算子,如果失败,先将state复位,再抛出异常.
 */
public class Try<T, E, Status, Tran> implements Parsec<T, E, Status, Tran> {
    private Parsec<T, E, Status, Tran> parsec;

    @Override
    public T parse(State<E, Status, Tran> s) throws EOFException, ParsecException {
        Tran tran = s.begin();
        try{
            T re = this.parsec.parse(s);
            s.commit(tran);
            return re;
        } catch (Exception e) {
            s.rollback(tran);
            throw e;
        }
    }

    public Try(Parsec<T, E, Status, Tran> parsec){
        this.parsec = parsec;
    }
}
