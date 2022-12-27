package com.example.geektrust;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProgramTest {
    @Test
    void certificationProgramIs3000() {
        Program certification = Program.Certification;
        assertEquals(3000, certification.fee(1));
    }

    @Test
    void degreeProgramIs5000() {
        Program certification = Program.Degree;
        assertEquals(5000, certification.fee(1));
    }

    @Test
    void diplomaProgramIs5000For2() {
        Program certification = Program.Diploma;
        assertEquals(5000, certification.fee(2));
    }
}
