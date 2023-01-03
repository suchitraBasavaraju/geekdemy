package com.example.geektrust;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class CourseTest {

    @Test
    void amountIs6000ForCertificationProgramWithQuantity2() {
        Course certification = new Course(Program.CERTIFICATION, 2);
        double amount = certification.amount();
        assertEquals(6000,amount);
    }

    @Test
    void amountIs3000ForCertificationProgramWithQuantity1() {
        Course certification = new Course(Program.CERTIFICATION, 1);
        double amount = certification.amount();
        assertEquals(3000,amount);
    }

    @Test
    void proDiscountIs120ForCertificationProgramWithQuantity2() {
        Course certification = new Course(Program.CERTIFICATION, 2);
        double amount = certification.proDiscount();
        assertEquals(120,amount);
    }

    @Test
    void proDiscountIs25ForDiplomaProgramWithQuantity1() {
        Course certification = new Course(Program.DIPLOMA, 1);
        double amount = certification.proDiscount();
        assertEquals(25,amount);
    }

    @Test
    void getNumberOfQuantity() {
        Course certification = new Course(Program.DIPLOMA, 1);
        assertEquals(1,  certification.getNumberOfCourse());
    }

    @Test
    void getProgramCertificationAmount() {
        Course certification = new Course(Program.DIPLOMA, 1);
        assertEquals(2500, certification.getProgramCertificationAmount());
    }
}