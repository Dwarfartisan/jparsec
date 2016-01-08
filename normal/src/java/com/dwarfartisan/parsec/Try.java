package com.dwarfartisan.parsec;

import java.io.EOFException;

/**
 * Created by Mars Liu on 16/1/1.
 */
public class Try<T, E> extends Parsec<T, E> {
    private Parsec<T, E> parser;
    public T parse(State<E> s) throws EOFException, ParsecException {
        int tran = s.begin();
        try {
            T re = this.parser.parse(s);
            s.commit(tran);
            return re;
        } catch (EOFException e) {
            s.rollback(tran);
            throw e;
        }catch (ParsecException e) {
            s.rollback(tran);
            throw e;
        }catch (Exception e) {
            s.rollback(tran);
            String message = String.format("Get a uncatch Exception %s", e);
            throw new ParsecException(s.index(), message);
        }
    }
    public Try(Parsec<T, E> parser) {
        this.parser = parser;
    }
}
