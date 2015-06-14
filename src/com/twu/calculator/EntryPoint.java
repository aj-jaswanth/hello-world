package com.twu.calculator;

import java.util.ArrayList;
import java.util.Scanner;

public class EntryPoint {
    public static void main(String[] args) {
        Model model = new Model();
        Scanner input = new Scanner(System.in);
        Parser parser = new Parser(model);
        History history = new History(new ArrayList<Operation>());
        View view = new View(input);
        App app = new App(parser, history, view);
        model.addObserver(view);
        app.start();
    }
}
