package com.twu.calculator.operations;

import com.twu.calculator.Model;
import com.twu.calculator.Operation;

public class Multiply implements Operation {

    private Model model;
    private double operand;

    public Multiply(Model model, double operand) {
        this.model = model;
        this.operand = operand;
    }

    @Override
    public void execute() {
        model.multiply(operand);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Multiply multiply = (Multiply) o;

        if (Double.compare(multiply.operand, operand) != 0) return false;
        return !(model != null ? !model.equals(multiply.model) : multiply.model != null);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = model != null ? model.hashCode() : 0;
        temp = Double.doubleToLongBits(operand);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
