package com.example.student_crud;

public class Student {
    private int roll;
    private String name;
    private String email;

    public Student(int roll, String name, String email) {
        this.roll=roll;
        this.name=name;
        this.email=email;
    }

    public int getRoll() {
        return roll;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setRoll(int roll) {
        this.roll=roll;
    }

    public void setName(String name) {
        this.name=name;
    }

    public void setEmail(String email) {
        this.email=email;
    }

}
