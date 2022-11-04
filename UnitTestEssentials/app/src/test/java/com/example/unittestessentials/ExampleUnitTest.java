package com.example.unittestessentials;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.function.ThrowingRunnable;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    Calculator calculator;

    @BeforeClass
    public static void beforeClass() throws Exception {

    }

    @AfterClass
    public static void afterClass() throws Exception {

    }

    @Before
    public void setUp() throws Exception {
        calculator = new Calculator();
    }

    @After
    public void tearDown() throws Exception {
        calculator = null;
    }

    @Test
    public void testAddition() {
        int result = calculator.add(10, 10);
        assertEquals(20, result);
    }


    @Test
    public void testMultiplication() {
        int result = calculator.multiply(10, 10);
        assertEquals(result, 100);
    }


    @Test
    public void testDivision() {
        int result = calculator.divide(10, 10);
        assertEquals(result, 1);
    }

    @Test
    public void testDivision_DivisorIsZero() {
        assertThrows(Exception.class, new ThrowingRunnable() {
            @Override
            public void run() throws Throwable {
                calculator.divide(10, 0);
            }
        });
    }
}