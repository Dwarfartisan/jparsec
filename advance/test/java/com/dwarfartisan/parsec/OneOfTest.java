package com.dwarfartisan.parsec;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.List;
import java.util.stream.IntStream;
import static java.util.stream.Collectors.toList;

/**
 * OneOf Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>一月 9, 2016</pre>
 */
public class OneOfTest extends Base{
    private String data = "It is a \"string\" for this unit test";


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
        State<Character, Integer, Integer> state = newState("hello");

        data = "hb";
        List<Character> buffer = IntStream.range(0, 2).mapToObj(data::charAt).collect(toList());
        OneOf<Character, Integer, Integer> oneOf = new OneOf<>(buffer);

        Character c = oneOf.parse(state);


        Assert.assertEquals(c,new Character('h'));

        try{
            Character d = oneOf.parse(state);
            String message = String.format("Expect a char in %s but %c", "hello", d);
            Assert.fail(message);
        }catch (ParsecException e){
            Assert.assertTrue(true);
        }
    }


} 
