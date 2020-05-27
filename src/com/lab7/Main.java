package com.lab7;

import com.lab7.P;
import com.lab7.Student;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        /**
         * Create list of students
         */
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(0, "Dasha", "Kozlova", "KB-71"));
        students.add(new Student(1, "Aliona", "Tenytska", "KB-71"));
        students.add(new Student(2, "Katya", "Zarydna", "KB-71"));
        students.add(new Student(3, "Maxym", "Basow", "KB-71"));
        students.add(new Student(4, "Kiril", "Shamonin", "KB-71"));

        for (Student student : students) {
            P.rintln(student.toString());
        }

    }
}