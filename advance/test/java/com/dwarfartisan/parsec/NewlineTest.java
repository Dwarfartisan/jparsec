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
        State<Character> state = newState("\r\n");
        Parsec<String, Character> crlf = new Crlf();

        String re = crlf.parse(state);
        Assert.assertEquals(re, "\r\n");

        State<Character> state1 = newState("\n");

        Parsec<Character, Character> enter = new Newline();

        Character c = enter.parse(state1);

        Assert.assertEquals(c.charValue(), '\n');


        State<Character> state2 = newState("\n\r");
        EndOfLine nl = new EndOfLine();

        String d = nl.parse(state2);
        Assert.assertEquals(d.length(),2);

        // TODO: 16/1/10  error test

    }
}
