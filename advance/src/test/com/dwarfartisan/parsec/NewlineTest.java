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
        State<Character> state = newState("\n\r");
        Parsec<String, Character> crlf = new Crlf();

        String b = crlf.parse(state);
        Assert.assertEquals(b, "\n\r");

        State<Character> state1 = newState("\n");

        Parsec<String, Character> enter = new Newline();

        String c = enter.parse(state1);

        Assert.assertEquals(c.length(),1);


        State<Character> state2 = newState("\n\r");
        EndOfLine nl = new EndOfLine();

        String d = nl.parse(state2);
        Assert.assertEquals(d.length(),2);

        // TODO: 16/1/10  error test

    }
}
