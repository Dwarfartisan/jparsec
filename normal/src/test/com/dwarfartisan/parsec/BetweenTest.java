package com.dwarfartisan.parsec;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * Between Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>一月 9, 2016</pre>
 */
public class BetweenTest extends Base {

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
    public void TestBetween() throws Exception {

        State<Character> state = newState("hello");


        Between<Character, Character, Character, Character> bmw = new Between<Character, Character, Character, Character>(
                new Eq<Character>('h'),
                new Eq<Character>('l'),
                new Eq<Character>('e')
        );

        Character c = bmw.parse(state);
        Assert.assertEquals(c, new Character('e'));

    }

    /**
     * Method: use(P<T, E> parser)
     */
    @Test
    public void testUse() throws Exception {
//TODO: Test goes here...
    }


} 
