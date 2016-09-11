package com.dwarfartisan.parsec;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by zhaonf on 16/1/10.
 */
public class SkipTest extends Base {
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
    public void TestSkip() throws Exception {
        State<Character, Integer, Integer> state = newState("hello World");
        Skip<Character,Character, Integer, Integer> skip = new Skip<>(new Eq<>('h'));
        Character c = skip.parse(state);
        Assert.assertEquals(c,null);

        Character d = state.next();

        Assert.assertEquals(d,new Character('e'));

        Character e = skip.parse(state);
        Assert.assertEquals(e,null);
        Character f = state.next();

        Assert.assertEquals(f,new Character('l'));
    }

}
