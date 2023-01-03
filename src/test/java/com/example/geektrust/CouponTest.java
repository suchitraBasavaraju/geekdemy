package com.example.geektrust;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CouponTest {
    @Test
    void FivePercentDiscountForDeal_G5() {
        Coupon coupon = Coupon.DEAL_G5;
        double discount = coupon.discount(100);
        assertEquals(5,discount);
    }

    @Test
    void TwoPercentDiscountForDeal_G20() {
        Coupon coupon = Coupon.DEAL_G20;
        double discount = coupon.discount(100);
        assertEquals(20,discount);
    }
}