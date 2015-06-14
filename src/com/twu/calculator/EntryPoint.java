package com.twu.calculator;

import java.util.Scanner;

public class EntryPoint {
    public static void main(String[] args) {
        Model model = new Model();
        Scanner input = new Scanner(System.in);
        Parser parser = new Parser(model);
        App app = new App(input, parser);
        View view = new View();
        model.addObserver(view);
        app.start();
    }
}
