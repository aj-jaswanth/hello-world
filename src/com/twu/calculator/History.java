package com.twu.calculator;

import java.util.List;

public class History {

    private List<Operation> operations;

    public History(List<Operation> operations) {
        this.operations = operations;
    }

    public void save(Operation operation) {
        operations.add(operation);
    }

    public List<Operation> getRecent(int count) {
        int totalOperations = operations.size();
        List<Operation> recentList = operations.subList(totalOperations - count, totalOperations);
        return recentList;
    }
}
