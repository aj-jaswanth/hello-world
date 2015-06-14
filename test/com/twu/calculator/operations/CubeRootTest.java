package com.twu.calculator.operations;

import com.twu.calculator.Model;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class CubeRootTest {

    private Model model;

    @Before
    public void setUp() {
        model = new Model();
    }

    @Test
    public void shouldReturnCorrectValue() {
        model.add(64);
        CubeRoot cubeRoot = new CubeRoot(model);

        cubeRoot.execute();
        String actualResult = model.toString();

        assertEquals("4.0", actualResult);
    }

    @Test
    public void equalityOfCubeRootAndNothing() {
        CubeRoot firstCubeRoot = new CubeRoot(model);

        boolean actual = firstCubeRoot.equals(null);

        assertThat(actual, is(false));
    }

    @Test
    public void equalityOfCubeRootAndOtherObject() {
        CubeRoot firstCubeRoot = new CubeRoot(model);

        boolean actual = firstCubeRoot.equals("OtherString");

        assertThat(actual, is(false));
    }

    @Test
    public void reflexivePropertyOfEqualsMethod() {
        CubeRoot firstCubeRoot = new CubeRoot(model);

        boolean actual = firstCubeRoot.equals(firstCubeRoot);

        assertThat(actual, is(true));
    }

    @Test
    public void symmetricPropertyOfEqualsMethod() {
        CubeRoot firstCubeRoot = new CubeRoot(model);
        CubeRoot secondCubeRoot = new CubeRoot(model);

        boolean actual = firstCubeRoot.equals(secondCubeRoot) == secondCubeRoot.equals(firstCubeRoot);

        assertThat(actual, is(true));
    }

    @Test
    public void transitivePropertyOfEqualsMethod() {
        CubeRoot firstCubeRoot = new CubeRoot(model);
        CubeRoot secondCubeRoot = new CubeRoot(model);
        CubeRoot thirdCubeRoot = new CubeRoot(model);

        boolean actual = firstCubeRoot.equals(secondCubeRoot) && secondCubeRoot.equals(thirdCubeRoot) && firstCubeRoot.equals(thirdCubeRoot);

        assertThat(actual, is(true));
    }

    @Test
    public void ifTwoCubeRootsAreEqualThenTheirHashCodesMustBeEqual() {
        CubeRoot firstCubeRoot = new CubeRoot(model);
        CubeRoot secondCubeRoot = new CubeRoot(model);

        boolean actual = firstCubeRoot.equals(secondCubeRoot) && firstCubeRoot.hashCode() == secondCubeRoot.hashCode();

        assertThat(actual, is(true));
    }

    @Test
    public void ifTwoCubeRootsAreDifferentThenTheirHashCodesMustBeDifferent() {
        CubeRoot firstCubeRoot = new CubeRoot(model);
        Model secondModel = new Model();
        secondModel.add(20);
        CubeRoot secondCubeRoot = new CubeRoot(secondModel);

        boolean actual = firstCubeRoot.equals(secondCubeRoot) && firstCubeRoot.hashCode() == secondCubeRoot.hashCode();

        assertThat(actual, is(false));
    }
}
