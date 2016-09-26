package com.dwarfartisan.parsec;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
    public void simple1() throws Exception {
        State<Character, Integer, Integer> state = newState("\r\n");
        Parsec<String, Character, Integer, Integer> nl = new Crlf<>();

        String re = nl.parse(state);
        Assert.assertEquals(re, "\r\n");

    }

    @Test
    public void simple2() throws Exception {
        State<Character, Integer, Integer> state = newState("\n");

        Parsec<String, Character, Integer, Integer> nl = new Newline<>();

        String re = nl.parse(state);

        Assert.assertEquals(re, "\r\n");
    }

    @Test
    public void simple3() throws Exception {
        State<Character, Integer, Integer> state = newState("\n24312");
        Parsec<String, Character, Integer, Integer> nl = new Newline<>();

        String re = nl.parse(state);
        Assert.assertEquals("\r\n", re);
    }
}
