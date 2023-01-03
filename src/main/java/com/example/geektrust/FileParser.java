package com.example.geektrust;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileParser {
    private final String fileName;
    private final List<String> lines = new ArrayList<>();

    private final List<Coupon> coupons = new ArrayList<>();
    private boolean proMembership;
    private final List<Course> courses = new ArrayList<>();
    private String bill;

    private static final DecimalFormat df = new DecimalFormat("0.00");

    public FileParser(String fileName) {
        this.fileName = fileName;
    }

    public String parseLines(List<String> parsedLines) {
        for (String line : parsedLines) {
            String[] cmd = line.split(" ");
            switch (cmd[0]) {
                case "ADD_PROGRAMME":
                    Program program = Program.valueOf(cmd[1]);
                    int quantity = Integer.parseInt(cmd[2]);
                    Course course = new Course(program, quantity);
                    courses.add(course);
                    break;
                case "APPLY_COUPON":
                    Coupon coupon = Coupon.valueOf(cmd[1]);
                    coupons.add(coupon);
                    break;
                case "ADD_PRO_MEMBERSHIP":
                    proMembership = true;
                    break;
                case "PRINT_BILL":
                    parseLines();
                    break;
            }
        }
        return bill;
    }

    private void parseLines() {
        Geekdemy geekdemy = new Geekdemy(courses, proMembership);
        geekdemy.addCoupon(coupons);

        double proDiscount = geekdemy.proDiscount();
        double subtotal = geekdemy.subtotal();
        double total = geekdemy.total();
        double couponDiscount = geekdemy.couponDiscount();
        String couponApplied = geekdemy.getCouponApplied();

        bill = "SUB_TOTAL " + df.format(subtotal) + "\n";
        bill = bill + "COUPON_DISCOUNT " + couponApplied + " " + df.format(couponDiscount) + "\n";
        bill = bill + "TOTAL_PRO_DISCOUNT " + df.format(proDiscount) + "\n";
        bill = bill + "PRO_MEMBERSHIP_FEE " + df.format(geekdemy.proMembershipFee()) + "\n";
        bill = bill + "ENROLLMENT_FEE " + df.format(geekdemy.enrolmentFee()) + "\n";
        bill = bill + "TOTAL " + df.format(total);
    }

    public List<String> parse() throws FileNotFoundException {
        FileInputStream fis = new FileInputStream(fileName);
        Scanner sc = new Scanner(fis); // file to be scanned
        while (sc.hasNextLine()) {
            String input = sc.nextLine();
            lines.add(input);
        }
        sc.close(); // closes the scanner
        return lines;
    }
}
