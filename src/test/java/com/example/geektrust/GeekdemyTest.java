package com.example.geektrust;

import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;

import static com.example.geektrust.Program.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GeekdemyTest {
    @Test
    void certificationCourseForQuantity2Is6000() {
        Geekdemy geekdemy = new Geekdemy(new Course(Program.Certification, 2));
        double amount = geekdemy.amount();
        assertEquals(6000,amount);
    }

    @Test
    void degreeCourseForQuantity0Is0() {
        Geekdemy geekdemy = new Geekdemy(new Course(Degree, 0));
        double amount = geekdemy.amount();
        assertEquals(0,amount);
    }

    @Test
    void calculatedFeesForMoreThanOneCourse() {
        Course certification = new Course(Certification, 2);
        Course diploma = new Course(Diploma, 1);
        Course degree = new Course(Degree, 0);
        List<Course> courses = new ArrayList<>();
        courses.add(certification);
        courses.add(diploma);
        courses.add(degree);
        Geekdemy geekdemy = new Geekdemy(courses);

        double amount = geekdemy.amount();

        assertEquals(8500,amount);
    }

}
