package com.twu.calculator.operations;

import com.twu.calculator.Model;
import com.twu.calculator.Operation;

public class Cancel implements Operation {

    private Model model;

    public Cancel(Model model) {
        this.model = model;
    }

    @Override
    public void execute() {
        model.cancel();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cancel cancel = (Cancel) o;

        return !(model != null ? !model.equals(cancel.model) : cancel.model != null);

    }

    @Override
    public int hashCode() {
        return model != null ? model.hashCode() : 0;
    }
}
