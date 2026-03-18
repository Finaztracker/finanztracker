package de.finanztrackerproject.service;

import de.finanztrackerproject.model.Transaction;
import java.util.ArrayList;
import java.util.List;

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

    public double berechneEinnahmen() {
        double total = 0;
        for (Transaction t : transactions) {
            if (t.getType().equals("Einkommen")) {
                total += t.getAmount();
            }
        }
        return total;
    }


    public double berechneAusgaben() {
        double total = 0;
        for (Transaction t : transactions) {
            if (t.getType().equals("Ausgabe")) {
                total += t.getAmount();
            }
        }
        return total;
    }

    public void zeigeTransaktion() {

        if (transactions.isEmpty()) {
            System.out.println("Keine Transaktionen vorhanden.");
            return;
        }

        for (Transaction t : transactions) {
            System.out.println(t);
        }

    }




}