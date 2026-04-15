package de.finanztrackerproject.service;

import de.finanztrackerproject.model.Transaction;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class TransactionService {

    private List<Transaction> transactions = new ArrayList<>();

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public double calculateBalance() {
        double balance = 0;

        for (Transaction t : transactions) {
            if (t.getType().equals("Einkommen")) {
                balance += t.getAmount();
            } else {
                balance -= t.getAmount();
            }
        }

        return balance;
    }

    public double calculateIncoming() {
        double total = 0;
        for (Transaction t : transactions) {
            if (t.getType().equals("Einkommen")) {
                total += t.getAmount();
            }
        }
        return total;
    }


    public double calculateExpenses() {
        double total = 0;
        for (Transaction t : transactions) {
            if (t.getType().equals("Ausgabe")) {
                total += t.getAmount();
            }
        }
        return total;
    }

    public void showTransaction() {

        if (transactions.isEmpty()) {
            System.out.println("Keine Transaktionen vorhanden.");
            return;
        }

        for (Transaction t : transactions) {
            System.out.println(t);
        }

    }

    public void saveToFile() {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("data.dat"));
            out.writeObject(transactions);
            out.close();
        } catch (IOException e) {
            System.out.println("Fehler beim Speichern!");
        }
    }

    public void loadFromFile() {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("data.dat"));
            transactions = (List<Transaction>) in.readObject();
            in.close();
        } catch (Exception e) {
            System.out.println("Keine alten Daten gefunden.");
        }
    }


}