package com.example.unittestessentials;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class IsPositiveTestClass {

    MathUtil util;
    @Before
    public void setUp() throws Exception {
        util = new MathUtil();

    }

    @Test
    public void isPositive_InputIsPositive_ReturnsTrue() {
        assertTrue(util.isPositive(5));
    }

    @Test
    public void isPositive_InputIsZero_ReturnsFalse() {
        assertFalse(util.isPositive(0));
    }


    @Test
    public void isPositive_InputIsNegative_ReturnsFalse() {
        assertFalse(util.isPositive(-1));
    }
}
