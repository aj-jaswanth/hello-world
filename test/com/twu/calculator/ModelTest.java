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
    public void shouldReturnCorrectStringRepresentation() {
        model.add(2331);
        String actualResult = model.toString();

        assertEquals("2331.0", actualResult);
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

    @Test
    public void shouldReturnCorrectValueWhenAbsoluteCommandIsPassed() {
        model.add(-10);
        model.absolute();
        String actualResult = outputContent.toString();

        assertEquals("-10.0\n10.0\n", actualResult);
    }

    @Test
    public void shouldReturnCorrectValueWhenNegateCommandIsPassed() {
        model.add(10);
        model.negate();
        String actualResult = outputContent.toString();

        assertEquals("10.0\n-10.0\n", actualResult);
    }

    @Test
    public void shouldReturnCorrectValueWhenSquareCommandIsPassed() {
        model.add(16);
        model.square();
        String actualResult = outputContent.toString();

        assertEquals("16.0\n256.0\n", actualResult);
    }

    @Test
    public void shouldReturnCorrectValueWhenSquareRootCommandIsPassed() {
        model.add(16);
        model.squareRoot();
        String actualResult = outputContent.toString();

        assertEquals("16.0\n4.0\n", actualResult);
    }

    @Test
    public void shouldReturnCorrectValueWhenCubeCommandIsPassed() {
        model.add(4);
        model.cube();
        String actualResult = outputContent.toString();

        assertEquals("4.0\n64.0\n", actualResult);
    }

    @Test
    public void shouldReturnCorrectValueWhenCubeRootCommandIsPassed() {
        model.add(64);
        model.cubeRoot();
        String actualResult = outputContent.toString();

        assertEquals("64.0\n4.0\n", actualResult);
    }
}
