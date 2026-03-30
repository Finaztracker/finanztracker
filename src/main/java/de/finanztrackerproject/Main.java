package de.finanztrackerproject;
import de.finanztrackerproject.ui.ConsoleUI;

public class Main {

    public static void main(String[] args) {
        System.out.println("Finanztracker gestartet");


        ConsoleUI ui = new ConsoleUI();

        ui.start();
    }
}