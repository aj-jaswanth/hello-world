package com.twu.calculator;

public class App {

    private Parser parser;
    private History history;
    private View view;

    public App(Parser parser, History history, View view) {
        this.parser = parser;
        this.history = history;
        this.view = view;
    }

    public void start() {
        String command;
        while (true) {
            command = view.readInput();
            if (isExit(command))
                return;
            Operation operation = parser.parse(command);
            if (operation != null) {
                operation.execute();
                history.save(operation);
            }
        }
    }

    private boolean isExit(String command) {
        return command.equals("exit");
    }
}
