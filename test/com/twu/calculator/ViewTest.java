package com.twu.calculator;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class ViewTest {

    private ByteArrayOutputStream outputContent;

    @Before
    public void setUp() {
        outputContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputContent));
    }

    @Test
    public void shouldPrintGivenValue() {
        View view = new View();

        view.displayResult(20.3);
        String actualResult = outputContent.toString();

        assertEquals("20.3\n", actualResult);
    }
}
