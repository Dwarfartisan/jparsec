package com.dwarfartisan.parsec;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by zhaonf on 16/1/10.
 */
public class ReturnTest extends Base {
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
    public void TestReturn() throws Exception {
        State<Character, Integer, Integer> state = newState("hhhlo World");
        Return<Character,Character, Integer, Integer> returns = new Return<>('h');
        Character c = returns.parse(state);
        Assert.assertEquals(c,new Character('h'));
    }
}
