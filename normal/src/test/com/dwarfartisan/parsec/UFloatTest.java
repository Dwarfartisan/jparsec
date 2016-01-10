package com.dwarfartisan.parsec;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by zhaonf on 16/1/10.
 */
public class UFloatTest extends Base {
    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void TestUFloat() throws Exception {
        State<Character> state = newState("002230.33");

        UFloat ufloat = new UFloat();
        String uf = ufloat.parse(state);
        if( ! uf.equals("002230.33") ){
            Assert.fail("UFloat conv failed");
        }

        State<Character> state1 = newState("002230");

        UFloat ufloat1 = new UFloat();
        try {
            String uf1 = ufloat1.parse(state1);
            Assert.fail("UFloat conv failed");
        }catch(Exception e){
            Assert.assertTrue(true);
        }

    }
}
