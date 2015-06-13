package com.twu.calculator;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ModelTest {

    @Test
    public void shouldReturnZeroWhenZeroIsAddedAsInitialCommand() {
        Model model = new Model();

        double actualResult = model.processCommand("add 0");

        assertThat(actualResult, is(0.0));
    }

    @Test
    public void shouldReturnCorrectValueWhenAValueIsAddedAsInitialCommand() {
        Model model = new Model();

        double actualResult = model.processCommand("add 10");

        assertThat(actualResult, is(10.0));
    }

    @Test
    public void shouldReturnCorrectValueWhenAValueIsAddedAsSecondCommand() {
        Model model = new Model();
        model.processCommand("add 10");

        double actualResult = model.processCommand("add 20");

        assertThat(actualResult, is(30.0));
    }

    @Test
    public void shouldReturnCorrectValueWhenAValueIsSubtractedAsSecondCommand() {
        Model model = new Model();
        model.processCommand("add 30");

        double actualResult = model.processCommand("subtract 20");

        assertThat(actualResult, is(10.0));
    }

    @Test
    public void shouldReturnCorrectValueWhenAValueIsMultipliedAsSecondCommand() {
        Model model = new Model();
        model.processCommand("add 10");

        double actualResult = model.processCommand("multiply 20");

        assertThat(actualResult, is(200.0));
    }

    @Test
    public void shouldReturnCorrectValueWhenAValueIsDividedAsSecondCommand() {
        Model model = new Model();
        model.processCommand("add 10");

        double actualResult = model.processCommand("divide 2");

        assertThat(actualResult, is(5.0));
    }

    @Test
    public void shouldSetTheCalculatorStateToZeroWhenCancelCommandIsPassed() {
        Model model = new Model();
        model.processCommand("add 10");

        double actualResult = model.processCommand("cancel");

        assertThat(actualResult, is(0.0));
    }
}
