package com.dwarfartisan.parsec;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by zhaonf on 16/1/10.
 */
public class NewlineTest extends Base {
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
    public void TestNewline() throws Exception {
        State<Character> state = newState("\r");
        Newline newline = new Newline();

        String b = newline.parse(state);
        Assert.assertEquals(b.length(),1);

        State<Character> state1 = newState("\n");

        Enter enter = new Enter();

        String c = enter.parse(state1);

        Assert.assertEquals(c.length(),1);


        State<Character> state2 = newState("\n\r");
        EnterNewline ennewline = new EnterNewline();

        String d = ennewline.parse(state2);
        Assert.assertEquals(d.length(),2);

        // TODO: 16/1/10  error test

    }
}
