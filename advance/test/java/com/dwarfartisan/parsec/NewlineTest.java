package com.dwarfartisan.parsec;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by zhaonf on 16/1/10.
 */
public class NewlineTest extends Base {
    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }
    /**
     * Method: parse(State<E> s)
     */
    @Test
    public void TestNewline() throws Exception {
        State<Character, Integer, Integer> state = newState("\r\n");
        Parsec<String, Character, Integer, Integer> crlf = new Crlf<>();

        String re = crlf.parse(state);
        Assert.assertEquals(re, "\r\n");

        State<Character, Integer, Integer> state1 = newState("\n");

        Parsec<Character, Character, Integer, Integer> enter = new Newline<>();

        Character c = enter.parse(state1);

        Assert.assertEquals(c.charValue(), '\n');


        State<Character, Integer, Integer> state2 = newState("\n\r");
        EndOfLine<Integer, Integer> nl = new EndOfLine<>();

        String d = nl.parse(state2);
        Assert.assertEquals(d.length(),2);

        // TODO: 16/1/10  error test

    }
}
