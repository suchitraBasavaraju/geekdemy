package com.example.geektrust;

import java.util.ArrayList;
import java.util.List;

import static com.example.geektrust.Coupon.*;

public class Geekdemy {
    public static final int PRO_MEMBERSHIP_FEE = 200;
    public static final int PROGRAM_COST_THRESHOLD = 6666;
    public static final int ENROLLMENT_FEE = 500;
    public static final int MINIMUM_COURSE_FOR_B4G1_COUPON = 4;
    public static final int MinimumPurchaseValue = 10000;
    public static final int Minimum_Programs = 2;

    private List<Course> courses = new ArrayList<>();
    private final boolean proMembership;
    private double amount;
    private double proDiscount;
    private double subTotal;
    private List<Coupon> coupons;
    private String couponApplied;

    public Geekdemy(Course course) {
        this.courses.add(course);
        proMembership = false;
    }

    public Geekdemy(List<Course> courses) {
        this.courses = courses;
        proMembership = false;
    }

    public Geekdemy(List<Course> courses, boolean proMembership) {
        this.courses = courses;
        this.proMembership = proMembership;
    }


    public double courseAmount() {
        amount = courses.stream().mapToDouble(Course::amount).sum();
        return amount;
    }

    public double proDiscount() {
        proDiscount = this.proMembership ? courses.stream().mapToDouble(Course::proDiscount).sum() : 0;
        return proDiscount;
    }

    public double subtotal() {
        subTotal = courseAmount();
        subTotal = subTotal - proDiscount() + proMembershipFee();
        subTotal = subTotal + enrolmentFee();
        return subTotal;
    }

    public double couponDiscount() {
        couponApplied = null;
        int numberOfCourses = numberOfCourses();
        if (numberOfCourses >= MINIMUM_COURSE_FOR_B4G1_COUPON) {
            couponApplied = "B4G1";

            return courses.stream().mapToDouble(Course::getProgramCertificationAmount).min().getAsDouble();
        }
        if (coupons == null) {
            return 0;
        }
        for (Coupon coupon : coupons) {
            if (couponApplied == null) {
                if (subTotal >= MinimumPurchaseValue && coupon == DEAL_G20) {
                    couponApplied = DEAL_G20.toString();
                    return DEAL_G20.discount(subTotal);
                }
                if (numberOfCourses >= Minimum_Programs && coupon == DEAL_G5) {
                    couponApplied = DEAL_G5.toString();
                    return DEAL_G5.discount(subTotal);
                }

            }

        }
        return 0;
    }

    private int numberOfCourses() {
        return courses.stream().mapToInt(Course::getNumberOfCourse).sum();
    }

    public double enrolmentFee() {
        double amount = courseAmount() - proDiscount() + proMembershipFee();
        return amount < PROGRAM_COST_THRESHOLD ? ENROLLMENT_FEE : 0;
    }

    public double proMembershipFee() {
        return this.proMembership ? PRO_MEMBERSHIP_FEE : 0;
    }

    public double total() {
        return this.subtotal() - couponDiscount();
    }

    public void addCoupon(List<Coupon> coupons) {
        this.coupons = coupons;
    }

    public String getCouponApplied() {
        return couponApplied;
    }
}
