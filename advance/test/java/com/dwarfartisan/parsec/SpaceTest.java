package com.dwarfartisan.parsec;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by zhaonf on 16/1/10.
 */
public class SpaceTest extends Base {

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
    public void TestSpace() throws Exception {
        State<Character, Integer, Integer> state = newState(" ");

        Space<Integer, Integer> s = new Space();

        Character a =  s.parse(state);
        Assert.assertEquals(a,new Character(' '));
    }
}
