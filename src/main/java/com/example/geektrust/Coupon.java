package com.example.geektrust;


public enum Coupon {
    DEAL_G5(0.05), DEAL_G20(0.2);

    private final double discountPercent;

    Coupon(double discountPercent) {
        this.discountPercent = discountPercent;
    }

    public double discount(double total) {
        return total * discountPercent;
    }
}
