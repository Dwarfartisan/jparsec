package com.dwarfartisan.parsec;

import java.io.EOFException;

/**
 * Created by Mars Liu on 16/1/1.
 */
public class Either<T, E> extends Parsec<T, E> {
    private Parsec<T, E> x;
    private Parsec<T, E> y;
    @Override
    public T parse(State<E> s) throws EOFException, ParsecException {
        int prev = s.index();
        try {
            return this.x.parse(s);
        } catch (EOFException e) {
            if(s.index() == prev) {
                return this.y.parse(s);
            } else {
                throw e;
            }
        } catch (ParsecException e) {
            if(s.index() == prev) {
                return this.y.parse(s);
            } else {
                throw e;
            }
        } catch (Exception e) {
            if(s.index() == prev) {
                return this.y.parse(s);
            } else {
                String message = String.format("Get a uncatch Exception %s", e);
                throw new ParsecException(s.index(), message);
            }
        }

    }
    public Either<T, E> or(Parsec<T, E> parser) {
        return new Either<T, E>(this, parser);
    }
    public Either(Parsec<T, E> x, Parsec<T, E> y) {
        this.x = x;
        this.y = y;
    }
}
