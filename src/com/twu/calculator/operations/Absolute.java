package com.twu.calculator.operations;

import com.twu.calculator.Model;
import com.twu.calculator.Operation;

public class Absolute implements Operation {

    private Model model;

    public Absolute(Model model) {
        this.model = model;
    }

    @Override
    public void execute() {
        model.absolute();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Absolute absolute = (Absolute) o;

        return !(model != null ? !model.equals(absolute.model) : absolute.model != null);

    }

    @Override
    public int hashCode() {
        return model != null ? model.hashCode() : 0;
    }
}
