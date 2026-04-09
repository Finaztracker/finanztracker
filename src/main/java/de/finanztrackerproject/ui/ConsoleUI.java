package de.finanztrackerproject.ui;

import de.finanztrackerproject.model.Transaction;
import de.finanztrackerproject.service.TransactionService;
import java.util.Scanner;
import java.time.LocalDate;

public class ConsoleUI {


    private TransactionService service = new TransactionService();
    private Scanner scanner = new Scanner(System.in);

    public void start() {
        boolean running = true;

        while (running) {
            System.out.println("\n--- FINANZTRACKER MENÜ ---");
            System.out.println("1. Transaktion hinzufügen");
            System.out.println("2. Alle Transaktionen anzeigen");
            System.out.println("3. Saldo anzeigen");
            System.out.println("4. Beenden");
            System.out.print("Deine Wahl: ");

            int wahl = scanner.nextInt();
            scanner.nextLine();

            if (wahl == 1) {
                System.out.print("Typ (Einkommen/Ausgabe): ");
                String typ = scanner.nextLine();
                System.out.print("Betrag: ");
                double betrag = scanner.nextDouble();
                scanner.nextLine();
                System.out.print("Kategorie: ");
                String kat = scanner.nextLine();
                System.out.print("Beschreibung: ");
                String desc = scanner.nextLine();

                Transaction t = new Transaction(0, typ, betrag, kat, desc, LocalDate.now());
                service.addTransaction(t);
                System.out.println("Gespeichert!");
            } else if (wahl == 2) {
                service.showTransaction();
            } else if (wahl == 3) {
                System.out.println("\n--- FINANZÜBERSICHT ---");
                System.out.println("Gesamteinnahmen: " + service.calculateIncoming() + "€");
                System.out.println("Gesamtausgaben:  " + service.calculateExpenses() + "€");
                System.out.println("Aktueller Saldo: " + service.calculateBalance() + "€");
            } else if (wahl == 4) {
                running = false;
                System.out.println("Tschüss!");
            }
        }
    }
}