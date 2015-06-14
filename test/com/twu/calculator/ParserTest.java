package com.twu.calculator;

import com.twu.calculator.operations.*;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class ParserTest {

    private Parser parser;
    private Model model;

    @Before
    public void setUp() {
        model = new Model();
        parser = new Parser(model);
    }

    @Test
    public void shouldReturnAddOperation() {
        Operation actualOperation = parser.parse("add 10");

        Operation expectedOperation = new Add(model, 10);

        assertEquals(expectedOperation, actualOperation);
    }

    @Test
    public void shouldReturnSubtractOperation() {
        Operation actualOperation = parser.parse("subtract 10");

        Operation expectedOperation = new Subtract(model, 10);

        assertEquals(expectedOperation, actualOperation);
    }

    @Test
    public void shouldReturnMultiplyOperation() {
        Operation actualOperation = parser.parse("multiply 10");

        Operation expectedOperation = new Multiply(model, 10);

        assertEquals(expectedOperation, actualOperation);
    }

    @Test
    public void shouldReturnDivideOperation() {
        Operation actualOperation = parser.parse("divide 10");

        Operation expectedOperation = new Divide(model, 10);

        assertEquals(expectedOperation, actualOperation);
    }

    @Test
    public void shouldReturnAbsoluteOperation() {
        Operation actualOperation = parser.parse("abs");

        Operation expectedOperation = new Absolute(model);

        assertEquals(expectedOperation, actualOperation);
    }

    @Test
    public void shouldReturnNegateOperation() {
        Operation actualOperation = parser.parse("neg");

        Operation expectedOperation = new Negate(model);

        assertEquals(expectedOperation, actualOperation);
    }

    @Test
    public void shouldReturnSquareOperation() {
        Operation actualOperation = parser.parse("sqr");

        Operation expectedOperation = new Square(model);

        assertEquals(expectedOperation, actualOperation);
    }

    @Test
    public void shouldReturnSquareRootOperation() {
        Operation actualOperation = parser.parse("sqrt");

        Operation expectedOperation = new SquareRoot(model);

        assertEquals(expectedOperation, actualOperation);
    }

    @Test
    public void shouldReturnCubeOperation() {
        Operation actualOperation = parser.parse("cube");

        Operation expectedOperation = new Cube(model);

        assertEquals(expectedOperation, actualOperation);
    }

    @Test
    public void shouldReturnCubeRootOperation() {
        Operation actualOperation = parser.parse("cubert");

        Operation expectedOperation = new CubeRoot(model);

        assertEquals(expectedOperation, actualOperation);
    }

    @Test
    public void shouldReturnCancelOperation() {
        Operation actualOperation = parser.parse("cancel");

        Operation expectedOperation = new Cancel(model);

        assertEquals(expectedOperation, actualOperation);
    }

    @Test
    public void shouldReturnNullOnInvalidInput() {
        Operation actualOperation = parser.parse("sub 20");

        Operation expectedOperation = null;

        assertEquals(expectedOperation, actualOperation);
    }
}
