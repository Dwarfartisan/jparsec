package com.dwarfartisan.parsec;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by zhaonf on 16/1/10.
 */
public class TryTest extends Base {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void TestTry() throws Exception {
        State<Character> state = newState("hello");

        Try<Character,Character> ttry = new Try<Character,Character>(
            new Eq<Character>(new Character('h')));

        Character s = ttry.parse(state);

        Assert.assertEquals(s,new Character('h'));

        State<Character> state1 = newState("sello");

        try{
            Character b = ttry.parse(state1);
            Assert.fail("not match");

        }catch(Exception e){
            if(!state1.next().equals(new Character('s'))){
                Assert.fail("not rollback");
            }
        }
    }
}
