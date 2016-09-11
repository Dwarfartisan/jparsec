package com.dwarfartisan.parsec;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by zhaonf on 16/1/10.
 */
public class Skip1Test extends Base {
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
    public void TestSkip1() throws Exception {
        State<Character, Integer, Integer> state = newState("hhhlo World");
        Skip1<Character,Character, Integer, Integer> skip = new Skip1<>(new Eq<>('h'));
        Character c = skip.parse(state);
        Assert.assertNull(c);
        c = state.next();
        Assert.assertEquals(c,new Character('l'));
    }

}
