package com.twu.calculator.operations;

import com.twu.calculator.Model;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class CubeTest {

    private Model model;

    @Before
    public void setUp() {
        model = new Model();
    }

    @Test
    public void shouldReturnCorrectValue() {
        model.add(4);
        Cube cube = new Cube(model);

        cube.execute();
        String actualResult = model.toString();

        assertEquals("64.0", actualResult);
    }

    @Test
    public void equalityOfCubeAndNothing() {
        Cube firstCube = new Cube(model);

        boolean actual = firstCube.equals(null);

        assertThat(actual, is(false));
    }

    @Test
    public void equalityOfCubeAndOtherObject() {
        Cube firstCube = new Cube(model);

        boolean actual = firstCube.equals("OtherString");

        assertThat(actual, is(false));
    }

    @Test
    public void reflexivePropertyOfEqualsMethod() {
        Cube firstCube = new Cube(model);

        boolean actual = firstCube.equals(firstCube);

        assertThat(actual, is(true));
    }

    @Test
    public void symmetricPropertyOfEqualsMethod() {
        Cube firstCube = new Cube(model);
        Cube secondCube = new Cube(model);

        boolean actual = firstCube.equals(secondCube) == secondCube.equals(firstCube);

        assertThat(actual, is(true));
    }

    @Test
    public void transitivePropertyOfEqualsMethod() {
        Cube firstCube = new Cube(model);
        Cube secondCube = new Cube(model);
        Cube thirdCube = new Cube(model);

        boolean actual = firstCube.equals(secondCube) && secondCube.equals(thirdCube) && firstCube.equals(thirdCube);

        assertThat(actual, is(true));
    }

    @Test
    public void ifTwoCubesAreEqualThenTheirHashCodesMustBeEqual() {
        Cube firstCube = new Cube(model);
        Cube secondCube = new Cube(model);

        boolean actual = firstCube.equals(secondCube) && firstCube.hashCode() == secondCube.hashCode();

        assertThat(actual, is(true));
    }

    @Test
    public void ifTwoCubesAreDifferentThenTheirHashCodesMustBeDifferent() {
        Model secondModel = new Model();
        model.add(20);
        Cube firstCube = new Cube(model);
        Cube secondCube = new Cube(secondModel);

        boolean actual = firstCube.equals(secondCube) && firstCube.hashCode() == secondCube.hashCode();

        assertThat(actual, is(false));
    }
}
