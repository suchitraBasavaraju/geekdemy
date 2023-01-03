package com.example.geektrust;

public enum Program {
    CERTIFICATION(3000, 2), DEGREE(5000, 3), DIPLOMA(2500, 1);

    private final int amount;
    private final int discountPercent;

    Program(int amount, int discountPercent) {
        this.amount = amount;
        this.discountPercent = discountPercent;
    }

    public double fee(int quantity) {
        return this.amount * quantity;
    }

    public double discount(int quantity) {
        return fee(quantity) * discountPercent / 100;
    }
}
