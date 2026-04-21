package de.finanztrackerproject;

import de.finanztrackerproject.ui.ConsoleUI;
import de.finanztrackerproject.ui.GuiUI;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("\n--- FINANZTRACKER UI AUSWAHL ---");
        System.out.println("1 = Console");
        System.out.println("2 = GUI");
        System.out.print("Auswahl: ");

        int wahl = scanner.nextInt();

        if (wahl == 1) {
            ConsoleUI ui = new ConsoleUI();
            ui.start();
        } else if (wahl == 2) {
            GuiUI gui = new GuiUI();
            gui.start();
        } else {
            System.out.println("Leider ungültige Auswahl!");
        }
    }
}