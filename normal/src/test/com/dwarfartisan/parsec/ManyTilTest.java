package com.dwarfartisan.parsec;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.List;

/**
 * ManyTil Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>一月 9, 2016</pre>
 */
public class ManyTilTest extends Base{

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
    public void TestManyTil() throws Exception {
        State<Character> state = newState("hhhhhhlhhhll");

        ManyTil<Character, Character, Character> m = new ManyTil<Character, Character, Character>(
                new Eq<Character>('h'),
                new Eq<Character>('l')
        );

        List<Character> a = m.parse(state);
        Assert.assertEquals(a.size(), 6);
    }


} 
