package de.finanztrackerproject.ui;

import de.finanztrackerproject.model.Transaction;
import de.finanztrackerproject.service.TransactionService;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class GuiUI {

    private TransactionService service = new TransactionService();

    private JFrame frame;
    private JTextArea outputArea;

    public void start() {
        frame = new JFrame("Finanztracker GUI");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));

        JButton addButton = new JButton("Transaktion hinzufügen");
        JButton showButton = new JButton("Alle Transaktionen anzeigen");
        JButton balanceButton = new JButton("Saldo anzeigen");

        outputArea = new JTextArea();
        outputArea.setEditable(false);

        // BUTTON: hinzufügen
        addButton.addActionListener(e -> {
            String typ = JOptionPane.showInputDialog("Typ (Einkommen/Ausgabe):");
            String betragStr = JOptionPane.showInputDialog("Betrag:");
            String kat = JOptionPane.showInputDialog("Kategorie:");
            String desc = JOptionPane.showInputDialog("Beschreibung:");

            try {
                double betrag = Double.parseDouble(betragStr);

                Transaction t = new Transaction(0, typ, betrag, kat, desc, LocalDate.now());
                service.addTransaction(t);

                outputArea.setText("Gespeichert!");
            } catch (Exception ex) {
                outputArea.setText("Fehler bei deiner Eingabe!");
            }
        });

        // BUTTON: anzeigen
        showButton.addActionListener(e -> {
            StringBuilder sb = new StringBuilder();

            if (service.getTransactions().isEmpty()) {
                sb.append("Keine Transaktionen vorhanden.");
            } else {
                for (Transaction t : service.getTransactions()) {
                    sb.append(t).append("\n");
                }
            }

            outputArea.setText(sb.toString());
        });

        // BUTTON: saldo
        balanceButton.addActionListener(e -> {
            String text = "--- FINANZÜBERSICHT ---\n"
                    + "Gesamteinnahmen: " + service.calculateIncoming() + "€\n"
                    + "Gesamtausgaben:  " + service.calculateExpenses() + "€\n"
                    + "Aktueller Saldo: " + service.calculateBalance() + "€";

            outputArea.setText(text);
        });

        panel.add(addButton);
        panel.add(showButton);
        panel.add(balanceButton);

        frame.add(panel, BorderLayout.NORTH);
        frame.add(new JScrollPane(outputArea), BorderLayout.CENTER);

        frame.setVisible(true);
    }
}