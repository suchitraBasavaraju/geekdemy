package com.example.geektrust;

public enum Program {
    Certification(3000), Degree(5000), Diploma(2500);

    private final int amount;

    Program(int amount) {
        this.amount = amount;
    }

    public double fee(int quantity) {
        return this.amount * quantity;
    }
}
