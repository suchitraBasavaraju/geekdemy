package com.example.geektrust;

public class Course {
    private final Program certification;
    private final int quantity;

    public Course(Program certification, int quantity) {
        this.certification = certification;
        this.quantity = quantity;
    }

    public Program getCertification() {
        return certification;
    }

    public int getQuantity() {
        return quantity;
    }

    public double amount() {
        return this.certification.fee(quantity);
    }
}
