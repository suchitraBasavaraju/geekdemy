package com.example.geektrust;

public class Course {
    private final Program certification;
    private final int quantity;

    public Course(Program certification, int quantity) {
        this.certification = certification;
        this.quantity = quantity;
    }

    public double amount() {
        return this.certification.fee(quantity);
    }

    public double proDiscount() {
        return this.certification.discount(quantity);
    }

    public int getNumberOfCourse() {
        return quantity;
    }

    public double getProgramCertificationAmount() {
        return certification.fee(1);
    }
}
