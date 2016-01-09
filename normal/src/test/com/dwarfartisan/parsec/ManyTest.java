package com.dwarfartisan.parsec;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.List;

/**
 * Many Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>一月 9, 2016</pre>
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
    public void TestMany() throws Exception {
        State<Character> state = newState("hhello");

        Many<Character, Character> m = new Many<Character, Character>(new Eq<Character>('h'));

        List<Character> a = m.parse(state);
        Assert.assertEquals(a.size(), 2);
    }


} 
