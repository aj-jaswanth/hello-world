package com.twu.calculator.operations;

import com.twu.calculator.Model;
import com.twu.calculator.Operation;

public class Negate implements Operation {

    private Model model;

    public Negate(Model model) {
        this.model = model;
    }

    @Override
    public void execute() {
        model.negate();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Negate negate = (Negate) o;

        return !(model != null ? !model.equals(negate.model) : negate.model != null);

    }

    @Override
    public int hashCode() {
        return model != null ? model.hashCode() : 0;
    }
}
