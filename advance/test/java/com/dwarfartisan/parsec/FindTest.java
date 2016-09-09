package com.dwarfartisan.parsec;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by march on 16/9/9.
 * JUnit tests for Find parser.
 */
public class FindTest extends Base {
    private String data;

    @Before
    public void before() {
        data = "It is a junit test case for find parsec.";
    }

    @Test
    public void simple() throws Exception {
        State<Character> state = newState(data);
        Parsec<String,Character> parser = new Find<>(new Text("find"));
        String re = parser.parse(state);
        Assert.assertEquals("find", re);
    }

}