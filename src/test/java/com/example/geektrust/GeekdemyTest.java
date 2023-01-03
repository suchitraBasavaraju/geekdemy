package com.example.geektrust;

import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;

import static com.example.geektrust.Program.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GeekdemyTest {
    @Test
    void certificationCourseForQuantity2Is6000() {
        Geekdemy geekdemy = new Geekdemy(new Course(Program.CERTIFICATION, 2));
        double amount = geekdemy.courseAmount();
        assertEquals(6000, amount);
    }

    @Test
    void degreeCourseForQuantity0Is0() {
        Geekdemy geekdemy = new Geekdemy(new Course(DEGREE, 0));
        double amount = geekdemy.courseAmount();
        assertEquals(0, amount);
    }

    @Test
    void calculatedFeesForMoreThanOneCourse() {
        Course certification = new Course(CERTIFICATION, 2);
        Course diploma = new Course(DIPLOMA, 1);
        Course degree = new Course(DEGREE, 0);
        List<Course> courses = new ArrayList<>();
        courses.add(certification);
        courses.add(diploma);
        courses.add(degree);
        Geekdemy geekdemy = new Geekdemy(courses);

        double amount = geekdemy.courseAmount();

        assertEquals(8500, amount);
    }

    @Test
    void proDiscountForMoreThanOneCourse() {
        Course certification = new Course(CERTIFICATION, 2);
        Course degree = new Course(DEGREE, 0);
        Course diploma = new Course(DIPLOMA, 1);
        List<Course> courses = new ArrayList<>();
        courses.add(certification);
        courses.add(diploma);
        courses.add(degree);
        Geekdemy geekdemy = new Geekdemy(courses, true);

        double subTotal = geekdemy.courseAmount();
        double proDiscount = geekdemy.proDiscount();

        assertEquals(8500, subTotal);
        assertEquals(145, proDiscount);
    }

    @Test
    void totalForMoreThanOneCourseWithProMembership() {
        Course certification = new Course(CERTIFICATION, 3);
        Course degree = new Course(DEGREE, 0);
        List<Course> courses = new ArrayList<>();
        courses.add(certification);
        courses.add(degree);
        Geekdemy geekdemy = new Geekdemy(courses, true);

        double courseAmount = geekdemy.courseAmount();
        double proDiscount = geekdemy.proDiscount();
        double subTotal = geekdemy.subtotal();

        assertEquals(9000, courseAmount);
        assertEquals(180, proDiscount);
        assertEquals(9020, subTotal);
    }

    @Test
    void couponB4G1GetsAppliedAutomaticallyWhen4ProgramsAreSelected() {
        Course certification = new Course(CERTIFICATION, 2);
        Course degree = new Course(DEGREE, 1);
        Course diploma = new Course(DIPLOMA, 1);
        List<Course> courses = new ArrayList<>();
        courses.add(certification);
        courses.add(diploma);
        courses.add(degree);
        Geekdemy geekdemy = new Geekdemy(courses);
        geekdemy.addCoupon(null);
        double courseAmount = geekdemy.courseAmount();
        double proDiscount = geekdemy.proDiscount();
        double couponDiscount = geekdemy.couponDiscount();

        assertEquals(13500, courseAmount);
        assertEquals(0, proDiscount);
        assertEquals(2500, couponDiscount);
    }


    @Test
    void couponDEAL_G20Applied() {
        Course degree = new Course(DEGREE, 3);
        List<Course> courses = new ArrayList<>();
        courses.add(degree);
        Geekdemy geekdemy = new Geekdemy(courses, true);
        Coupon dealG20 = Coupon.DEAL_G20;
        List<Coupon> coupons = new ArrayList<>();
        coupons.add(dealG20);
        geekdemy.addCoupon(coupons);

        double courseAmount = geekdemy.courseAmount();
        double proDiscount = geekdemy.proDiscount();
        double subtotal = geekdemy.subtotal();
        double total = geekdemy.total();
        double couponDiscount = geekdemy.couponDiscount();

        assertEquals(15000, courseAmount);
        assertEquals(450, proDiscount);
        assertEquals(2950, couponDiscount);
        assertEquals(14750, subtotal);
        assertEquals(11800, total);
    }

    @Test
    void couponDEAL_G5Applied() {
        Course degree = new Course(DEGREE, 2);
        List<Course> courses = new ArrayList<>();
        courses.add(degree);
        Geekdemy geekdemy = new Geekdemy(courses, false);
        Coupon dealG20 = Coupon.DEAL_G5;
        List<Coupon> coupons = new ArrayList<>();
        coupons.add(dealG20);
        geekdemy.addCoupon(coupons);

        double courseAmount = geekdemy.courseAmount();
        double proDiscount = geekdemy.proDiscount();
        double subtotal = geekdemy.subtotal();
        double total = geekdemy.total();
        double couponDiscount = geekdemy.couponDiscount();

        assertEquals(10000, courseAmount);
        assertEquals(0, proDiscount);
        assertEquals(500, couponDiscount);
        assertEquals(10000, subtotal);
        assertEquals(9500, total);
        assertEquals("DEAL_G5", geekdemy.getCouponApplied());
    }

    @Test
    void NoCouponeDealApplied() {
        Course degree = new Course(DEGREE, 2);
        List<Course> courses = new ArrayList<>();
        courses.add(degree);
        Geekdemy geekdemy = new Geekdemy(courses, false);
        geekdemy.addCoupon(null);

        double courseAmount = geekdemy.courseAmount();
        double proDiscount = geekdemy.proDiscount();
        double subtotal = geekdemy.subtotal();
        double total = geekdemy.total();
        double couponDiscount = geekdemy.couponDiscount();

        assertEquals(10000, courseAmount);
        assertEquals(0, proDiscount);
        assertEquals(0, couponDiscount);
        assertEquals(10000, subtotal);
        assertEquals(10000, total);
        assertEquals(null, geekdemy.getCouponApplied());
    }

    @Test
    void programCostBelow6666WithEnrollmentFee500() {
        Course certification = new Course(CERTIFICATION, 2);
        Course degree = new Course(DEGREE, 0);
        List<Course> courses = new ArrayList<>();
        courses.add(certification);
        courses.add(degree);
        Geekdemy geekdemy = new Geekdemy(courses, true);

        double courseAmount = geekdemy.courseAmount();
        double proDiscount = geekdemy.proDiscount();
        double subTotal = geekdemy.subtotal();
        double total = geekdemy.total();

        assertEquals(6000, courseAmount);
        assertEquals(120, proDiscount);
        assertEquals(6580, subTotal);
        assertEquals(6580, total);
    }
}
