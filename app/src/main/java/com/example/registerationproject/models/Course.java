package com.example.registerationproject.models;

import com.google.firebase.firestore.PropertyName;

public class Course {

    private String name;
    private String grade;
    private String division;
    private String credit;
    private String major;
    private String professor; // 교수 이름 필드 추가

    // Default constructor (required by Firestore)
    public Course() {}

    // Constructor with parameters
    public Course(String name, String grade, String division, String credit, String major, String professor) {
        this.name = name;
        this.grade = grade;
        this.division = division;
        this.credit = credit;
        this.major = major;
        this.professor = professor; // 생성자에도 교수 이름 추가
    }

    // Getters and setters for each field
    @PropertyName("name")
    public String getName() {
        return name;
    }

    @PropertyName("name")
    public void setName(String name) {
        this.name = name;
    }

    @PropertyName("grade")
    public String getGrade() {
        return grade;
    }

    @PropertyName("grade")
    public void setGrade(String grade) {
        this.grade = grade;
    }

    @PropertyName("division")
    public String getDivision() {
        return division;
    }

    @PropertyName("division")
    public void setDivision(String division) {
        this.division = division;
    }

    @PropertyName("credit")
    public String getCredit() {
        return credit;
    }

    @PropertyName("credit")
    public void setCredit(String credit) {
        this.credit = credit;
    }

    @PropertyName("major")
    public String getMajor() {
        return major;
    }

    @PropertyName("major")
    public void setMajor(String major) {
        this.major = major;
    }

    @PropertyName("professor") // 교수 이름을 위한 어노테이션 추가
    public String getProfessor() {
        return professor;
    }

    @PropertyName("professor") // 교수 이름을 위한 어노테이션 추가
    public void setProfessor(String professor) {
        this.professor = professor;
    }
}
