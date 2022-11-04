package com.example.unittestessentials;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class StringUtilTestClass {

    StringUtil util;
    @Before
    public void setUp() throws Exception {
        util = new StringUtil();
    }

    @Test
    public void reverse_EmptyString_EmptyString() {
        String result = util.reverse("");
        assertEquals("", result);
    }

    @Test
    public void reverse_SingleCharacterInput_SingleCharacter() {
        String result = util.reverse("a");
        assertEquals("a", result);
    }

    @Test
    public void reverse_LongStringInput_ReverseOfInputString() {
        String result = util.reverse("abcdef");
        assertEquals("fedcba", result);
    }
}
