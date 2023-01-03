package com.example.geektrust;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProgramTest {
    @Test
    void certificationProgramIs3000() {
        Program certification = Program.CERTIFICATION;
        assertEquals(3000, certification.fee(1));
    }

    @Test
    void degreeProgramIs5000() {
        Program degree = Program.DEGREE;
        assertEquals(5000, degree.fee(1));
    }

    @Test
    void diplomaProgramIs5000For2() {
        Program diploma = Program.DIPLOMA;
        assertEquals(5000, diploma.fee(2));
    }

    @Test
    void diplomaProgramDiscountIs1Percent() {
        Program diploma = Program.DIPLOMA;
        assertEquals(50, diploma.discount(2));
    }

    @Test
    void certificationProgramDiscountIs2Percent() {
        Program diploma = Program.CERTIFICATION;
        assertEquals(120, diploma.discount(2));
    }

    @Test
    void degreeProgramDiscountIs3Percent() {
        Program diploma = Program.DEGREE;
        assertEquals(300, diploma.discount(2));
    }
}
