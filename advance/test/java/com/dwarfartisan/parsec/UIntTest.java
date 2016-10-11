package com.dwarfartisan.parsec;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by zhaonf on 16/1/10.
 */
public class UIntTest extends Base {
    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void simple() throws Exception {
        State<Character, Integer, Integer> state = newState("62535");

        UInt<Integer, Integer> uint = new UInt<>();

        String s = uint.parse(state);

        Assert.assertEquals(s,"62535");
    }

    @Test
    public void stopAtMiddle() throws Exception {
        State<Character, Integer, Integer> state = newState("625k35");

        UInt<Integer, Integer> uint = new UInt<>();

        String s = uint.parse(state);

        Assert.assertEquals(s,"625");
    }
}
