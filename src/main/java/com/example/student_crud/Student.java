package com.example.student_crud;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Student {
    @JsonProperty("id") private int roll;
    @JsonProperty("name") private String name;
    @JsonProperty("phone") private String phone;

    public Student(int roll, String name, String phone) {
        this.roll=roll;
        this.name=name;
        this.phone=phone;
    }

    public int getRoll() {
        return roll;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public void setRoll(int roll) {
        this.roll=roll;
    }

    public void setName(String name) {
        this.name=name;
    }

    public void setPhone(String phone) {
        this.phone=phone;
    }

}
