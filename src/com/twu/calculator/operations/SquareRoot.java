package com.twu.calculator.operations;

import com.twu.calculator.Model;
import com.twu.calculator.Operation;

public class SquareRoot implements Operation {

    private Model model;

    public SquareRoot(Model model) {
        this.model = model;
    }

    @Override
    public void execute() {
        model.squareRoot();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SquareRoot that = (SquareRoot) o;

        return !(model != null ? !model.equals(that.model) : that.model != null);

    }

    @Override
    public int hashCode() {
        return model != null ? model.hashCode() : 0;
    }
}
