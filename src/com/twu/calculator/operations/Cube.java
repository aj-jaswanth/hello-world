package com.twu.calculator.operations;

import com.twu.calculator.Model;
import com.twu.calculator.Operation;

public class Cube implements Operation {

    private Model model;

    public Cube(Model model) {
        this.model = model;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cube cube = (Cube) o;

        return !(model != null ? !model.equals(cube.model) : cube.model != null);

    }

    @Override
    public int hashCode() {
        return model != null ? model.hashCode() : 0;
    }

    @Override
    public void execute() {
        model.cube();

    }
}
