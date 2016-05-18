package com.dwarfartisan.parsec;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import com.dwarfartisan.parsec.ParsecException;

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
    @Test(expected=ParsecException.class)
    public void TestNewline0() throws Exception {
        State<Character> state = newState("\r");
        Newline newline = new Newline();
        
        String b = newline.parse(state);
        Assert.assertEquals(b.length(),1);
    }

    @Test
    public void TestNewline1() throws Exception {
        State<Character> state1 = newState("\n");
        Newline enter = new Newline();
        String c = enter.parse(state1);
        Assert.assertEquals(c.length(),1);
    }

    @Test
    public void TestNewline2() throws Exception {
        State<Character> state2 = newState("\n\r");
        EndOfLine ennewline = new EndOfLine();

        String d = ennewline.parse(state2);
        Assert.assertEquals(d.length(),2);

    }
}
