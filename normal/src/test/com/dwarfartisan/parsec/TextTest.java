package com.dwarfartisan.parsec;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by zhaonf on 16/1/10.
 */
public class TextTest extends Base {

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
    public void TestText() throws Exception {
        State<Character> state = newState("Hello World");

        Text s = new Text("Hello World");

        String a =  s.parse(state);

        Assert.assertEquals(a,"Hello World");



    }

}
