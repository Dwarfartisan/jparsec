package com.dwarfartisan.parsec;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.io.EOFException;

/**
 * NoneOf Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>一月 9, 2016</pre>
 */
public class NoneOfTest extends Base {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: parse(State<T> s)
     */
    @Test
    public void testParse() throws Exception {
        State<Character> state = newState("hello");

        NoneOf<Character> noneof = new NoneOf<Character>(new Character[]{'s', 'b'});

        Character c = noneof.parse(state);

        Assert.assertEquals(c, new Character('h'));

        try {
            State<Character> state2 = newState("sello");
            Character d = noneof.parse(state2);
            Assert.fail("not matched");
        } catch (ParsecException e){
            Assert.assertTrue(true);
        }
    }


} 
