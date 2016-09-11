package com.dwarfartisan.parsec;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toSet;

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
    public void simpleOK() throws Exception {
        State<Character, Integer, Integer> state = newState("hello");

        NoneOf<Character, Integer, Integer> noneOf = new NoneOf<>(Stream.of('k', 'o', 'f').collect(toSet()));
        Character c = noneOf.parse(state);

        Assert.assertEquals(c, new Character('h'));
    }

    @Test
    public void simpleFail() throws Exception {
        NoneOf<Character, Integer, Integer> noneOf = new NoneOf<>(Stream.of('k', 'f', 's').collect(toSet()));
        try {
            String content = "sound";
            State<Character, Integer, Integer> state2 = newState(content);
            Character d = noneOf.parse(state2);
            String message = String.format("Expect none of \"%s\" failed  but '%c'", "kfs", d);
            Assert.fail(message);
        } catch (ParsecException e){
            Assert.assertTrue(true);
        }
    }


} 
