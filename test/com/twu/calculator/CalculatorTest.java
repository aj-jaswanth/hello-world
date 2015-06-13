package com.twu.calculator;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CalculatorTest {

    @Test
    public void shouldReturnZeroWhenZeroIsAddedAsInitialCommand() {
        Calculator calculator = new Calculator();

        double actualResult = calculator.processCommand("add 0");

        assertThat(actualResult, is(0.0));
    }

    @Test
    public void shouldReturnCorrectValueWhenAValueIsAddedAsInitialCommand() {
        Calculator calculator = new Calculator();

        double actualResult = calculator.processCommand("add 10");

        assertThat(actualResult, is(10.0));
    }

    @Test
    public void shouldReturnCorrectValueWhenAValueIsAddedAsSecondCommand() {
        Calculator calculator = new Calculator();
        calculator.processCommand("add 10");

        double actualResult = calculator.processCommand("add 20");

        assertThat(actualResult, is(30.0));
    }

    @Test
    public void shouldReturnCorrectValueWhenAValueIsSubtractedAsSecondCommand() {
        Calculator calculator = new Calculator();
        calculator.processCommand("add 30");

        double actualResult = calculator.processCommand("subtract 20");

        assertThat(actualResult, is(10.0));
    }

    @Test
    public void shouldReturnCorrectValueWhenAValueIsMultipliedAsSecondCommand() {
        Calculator calculator = new Calculator();
        calculator.processCommand("add 10");

        double actualResult = calculator.processCommand("multiply 20");

        assertThat(actualResult, is(200.0));
    }

    @Test
    public void shouldReturnCorrectValueWhenAValueIsDividedAsSecondCommand() {
        Calculator calculator = new Calculator();
        calculator.processCommand("add 10");

        double actualResult = calculator.processCommand("divide 2");

        assertThat(actualResult, is(5.0));
    }

    @Test
    public void shouldSetTheCalculatorStateToZeroWhenCancelCommandIsPassed() {
        Calculator calculator = new Calculator();
        calculator.processCommand("add 10");

        double actualResult = calculator.processCommand("cancel");

        assertThat(actualResult, is(0.0));
    }
}
