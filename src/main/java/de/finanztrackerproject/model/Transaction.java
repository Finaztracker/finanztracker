package de.finanztrackerproject.model;
import java.time.LocalDate;

public class Transaction {


    private int id;
    private String type;
    private double amount;
    private String category;
    private String description;
    private LocalDate date;

    public Transaction(int id, String type, double amount, String category, String description, LocalDate date) {
        this.id = id;
        this.type = type;
        this.amount = amount;
        this.category = category;
        this.description = description;
        this.date = date;
    }

    public int getId() { return id; }
    public String getType() { return type; }
    public double getAmount() { return amount; }
    public String getCategory() { return category; }
    public String getDescription() { return description; }
    public LocalDate getDate() { return date; }

    @Override
    public String toString() {
        return date + " | " + type + " | " + category + " | " + amount + " | " + description;
    }


}