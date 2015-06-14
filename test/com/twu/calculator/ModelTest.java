package com.twu.calculator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class ModelTest {

    private Model model;
    private View view;
    private ByteArrayOutputStream outputContent;

    @Before
    public void setUp() {
        model = new Model();
        view = new View();
        outputContent = new ByteArrayOutputStream();
        model.addObserver(view);
        System.setOut(new PrintStream(outputContent));
    }

    @After
    public void tearDown() {
        System.setOut(null);
    }

    @Test
    public void shouldReturnZeroWhenZeroIsAddedAsInitialCommand() {
        model.add(0);
        String actualResult = outputContent.toString();

        assertEquals("0.0\n", actualResult);
    }

    @Test
    public void shouldReturnCorrectValueWhenAValueIsAddedAsInitialCommand() {
        model.add(10);
        String actualResult = outputContent.toString();

        assertEquals("10.0\n", actualResult);
    }

    @Test
    public void shouldReturnCorrectValueWhenAValueIsAddedAsSecondCommand() {
        model.add(10);
        model.add(20);
        String actualResult = outputContent.toString();

        assertEquals("10.0\n30.0\n", actualResult);
    }


    @Test
    public void shouldReturnCorrectValueWhenAValueIsSubtractedAsSecondCommand() {
        model.add(30);
        model.subtract(20);
        String actualResult = outputContent.toString();

        assertEquals("30.0\n10.0\n", actualResult);
    }

    @Test
    public void shouldReturnCorrectValueWhenAValueIsMultipliedAsSecondCommand() {
        model.add(10);
        model.multiply(20);
        String actualResult = outputContent.toString();

        assertEquals("10.0\n200.0\n", actualResult);
    }


    @Test
    public void shouldReturnCorrectValueWhenAValueIsDividedAsSecondCommand() {
        model.add(10);
        model.divide(2);
        String actualResult = outputContent.toString();

        assertEquals("10.0\n5.0\n", actualResult);
    }

    @Test
    public void shouldSetTheCalculatorStateToZeroWhenCancelCommandIsPassed() {
        model.add(10);
        model.cancel();
        String actualResult = outputContent.toString();

        assertEquals("10.0\n0.0\n", actualResult);
    }
}
