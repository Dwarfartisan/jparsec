package com.dwarfartisan.parsec;

import java.io.EOFException;

/**
 * Created by Mars Liu on 16/1/1.
 */
public class Either<T, E> extends Parsec<T, E> {
    private P<T, E> x;
    private P<T, E> y;
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
    public Either or(P<T, E> parser) {
        return new Either<T, E>(this, parser);
    }
    public Either(P<T, E> x, P<T, E> y) {
        this.x = x;
        this.y = y;
    }
}
