package com.twu.calculator.operations;

import com.twu.calculator.Model;
import com.twu.calculator.Operation;

public class Divide implements Operation {

    private Model model;
    private double operand;

    public Divide(Model model, double operand) {
        this.model = model;
        this.operand = operand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Divide divide = (Divide) o;

        if (Double.compare(divide.operand, operand) != 0) return false;
        return !(model != null ? !model.equals(divide.model) : divide.model != null);

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

    @Override
    public void execute() {
        model.divide(operand);
    }
}
