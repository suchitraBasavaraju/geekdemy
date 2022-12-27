package com.example.geektrust;

import java.util.ArrayList;
import java.util.List;

public class Geekdemy {
    private List<Course> courses = new ArrayList<>();

    public Geekdemy(Course course) {
        this.courses.add(course);
    }

    public Geekdemy(List<Course> courses) {
        this.courses = courses;
    }

    public double amount() {
        double amount = courses.stream().mapToDouble(Course::amount).sum();
        return amount;
    }
}
