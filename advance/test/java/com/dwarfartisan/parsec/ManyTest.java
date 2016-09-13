package com.dwarfartisan.parsec;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.List;

/**
 * Many Tester.
 *
 * @author Mars Liu
 */
public class ManyTest extends Base {

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
    public void simple() throws Exception {
        State<Character, Integer, Integer> state = newState("hhello");

        Many<Character, Character, Integer, Integer> m = new Many<>(new Eq<>('h'));

        List<Character> a = m.parse(state);
        Assert.assertEquals(a.size(), 2);
    }
}
