// Course.java

package com.example.registerationproject.models;

import com.google.firebase.firestore.PropertyName;

public class Course {

    private String course;
    private String grade;
    private String division;
    private String credit;
    private String major;
    private String professor;

    // Default constructor (required by Firestore)
    public Course() {}

    // Constructor with parameters
    public Course(String course, String grade, String division, String credit, String major, String professor) {
        this.course = course;
        this.grade = grade;
        this.division = division;
        this.credit = credit;
        this.major = major;
        this.professor = professor;
    }

    // Getters and setters for each field
    @PropertyName("course")
    public String getCourse() {
        return course;
    }

    @PropertyName("course")
    public void setCourse(String course) {
        this.course = course;
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

    @PropertyName("professor")
    public String getProfessor() {
        return professor;
    }

    @PropertyName("professor")
    public void setProfessor(String professor) {
        this.professor = professor;
    }
}
