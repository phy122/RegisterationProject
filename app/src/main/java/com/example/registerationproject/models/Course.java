package com.example.registerationproject.models;

import com.google.firebase.firestore.PropertyName;

import java.io.Serializable;

public class Course implements Serializable {

    private String courseName;
    private String grade;
    private String division;
    private String credit;
    private String major;
    private String professor;
    private String mondayStartTime; // 월요일 시작 시간
    private String mondayEndTime;
    private String tuesdayStartTime;
    private String tuesdayEndTime;// 월요일 종료 시간
    private String wednesdayStartTime; // 수요일 시작 시간
    private String wednesdayEndTime;
    private String thursdayStartTime; // 수요일 시작 시간
    private String thursdayEndTime;
    private String fridayStartTime; // 수요일 시작 시간
    private String fridayEndTime;
    private String dayOfWeek;
    private String mondayStartTime2; // 월요일 시작 시간
    private String mondayEndTime2;
    private String tuesdayStartTime2;
    private String tuesdayEndTime2;// 월요일 종료 시간
    private String wednesdayStartTime2; // 수요일 시작 시간
    private String wednesdayEndTime2;
    private String thursdayStartTime2; // 수요일 시작 시간
    private String thursdayEndTime2;
    private String fridayStartTime2; // 수요일 시작 시간
    private String fridayEndTime2;
    private String dayOfWeek2;
    private int personnel; // 수강 신청 인원
    private int limit; //수강 제한 인원
    private int courseRival;

    // Default constructor (required by Firestore)
    public Course() {}


    public void setTuesdayEndTime(String tuesdayEndTime) {
        this.tuesdayEndTime = tuesdayEndTime;
    }

    public String getMondayStartTime2() {
        return mondayStartTime2;
    }

    public void setMondayStartTime2(String mondayStartTime2) {
        this.mondayStartTime2 = mondayStartTime2;
    }

    public String getMondayEndTime2() {
        return mondayEndTime2;
    }

    public void setMondayEndTime2(String mondayEndTime2) {
        this.mondayEndTime2 = mondayEndTime2;
    }

    public String getTuesdayStartTime2() {
        return tuesdayStartTime2;
    }

    public void setTuesdayStartTime2(String tuesdayStartTime2) {
        this.tuesdayStartTime2 = tuesdayStartTime2;
    }

    public String getTuesdayEndTime2() {
        return tuesdayEndTime2;
    }

    public void setTuesdayEndTime2(String tuesdayEndTime2) {
        this.tuesdayEndTime2 = tuesdayEndTime2;
    }

    public String getWednesdayStartTime2() {
        return wednesdayStartTime2;
    }

    public void setWednesdayStartTime2(String wednesdayStartTime2) {
        this.wednesdayStartTime2 = wednesdayStartTime2;
    }

    public String getWednesdayEndTime2() {
        return wednesdayEndTime2;
    }

    public void setWednesdayEndTime2(String wednesdayEndTime2) {
        this.wednesdayEndTime2 = wednesdayEndTime2;
    }

    public String getThursdayStartTime2() {
        return thursdayStartTime2;
    }

    public void setThursdayStartTime2(String thursdayStartTime2) {
        this.thursdayStartTime2 = thursdayStartTime2;
    }

    public String getThursdayEndTime2() {
        return thursdayEndTime2;
    }

    public void setThursdayEndTime2(String thursdayEndTime2) {
        this.thursdayEndTime2 = thursdayEndTime2;
    }

    public String getFridayStartTime2() {
        return fridayStartTime2;
    }

    public void setFridayStartTime2(String fridayStartTime2) {
        this.fridayStartTime2 = fridayStartTime2;
    }

    public String getFridayEndTime2() {
        return fridayEndTime2;
    }

    public void setFridayEndTime2(String fridayEndTime2) {
        this.fridayEndTime2 = fridayEndTime2;
    }

    public String getDayOfWeek2() {
        return dayOfWeek2;
    }

    public void setDayOfWeek2(String dayOfWeek2) {
        this.dayOfWeek2 = dayOfWeek2;
    }

    // Constructor with parameters
    public Course(String courseName, String grade, String division, String credit, String major, String professor,  String dayOfWeek,int limit, String mondayStartTime, String mondayEndTime, String wednesdayStartTime, String wednesdayEndTime,String getDayOfWeekString,String tuesdayStartTime,String tuesdayEndTime,String thursdayStartTime,String thursEndTime,String fridayStartTime,String fridayEndTime, int personnel,int courseRival) {
        this.courseName = courseName;
        this.grade = grade;
        this.division = division;
        this.credit = credit;
        this.major = major;
        this.professor = professor;
        this.mondayStartTime = mondayStartTime;
        this.mondayEndTime = mondayEndTime;
        this.tuesdayStartTime = tuesdayStartTime;
        this.tuesdayEndTime = tuesdayEndTime;
        this.wednesdayStartTime = wednesdayStartTime;
        this.wednesdayEndTime = wednesdayEndTime;
        this.thursdayStartTime = thursdayStartTime;
        this.thursdayEndTime = thursdayEndTime;
        this.fridayStartTime = fridayStartTime;
        this.fridayEndTime = fridayEndTime;
        this.dayOfWeek = dayOfWeek;
        this.personnel = personnel;
        this.courseRival = courseRival;
        this.limit = limit;

    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getCourseRival() {
        return courseRival;
    }

    public void setCourseRival(int courseRival) {
        this.courseRival = courseRival;
    }

    public int getPersonnel() {
        return personnel;
    }

    public void setPersonnel(int personnel) {
        this.personnel = personnel;
    }

    // Getters and setters for each field
    @PropertyName("courseName")
    public String getCourseName() {
        return courseName;
    }

    @PropertyName("courseName")
    public void setCourseName(String courseName) {
        this.courseName = courseName;
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

    public String getMondayStartTime() {
        return mondayStartTime;
    }

    public void setMondayStartTime(String mondayStartTime) {
        this.mondayStartTime = mondayStartTime;
    }

    public String getMondayEndTime() {
        return mondayEndTime;
    }

    public void setMondayEndTime(String mondayEndTime) {
        this.mondayEndTime = mondayEndTime;
    }

    public String getTuesdayStartTime() {
        return tuesdayStartTime;
    }

    public void setTuesdayStartTime(String tuesdayStartTime) {
        this.tuesdayStartTime = tuesdayStartTime;
    }

    public String getTuesdayEndTime() {
        return tuesdayEndTime;
    }

    public void setTuesdaySEndTime(String tuesdaySEndTime) {
        this.tuesdayEndTime = tuesdaySEndTime;
    }

    public String getWednesdayStartTime() {
        return wednesdayStartTime;
    }

    public void setWednesdayStartTime(String wednesdayStartTime) {
        this.wednesdayStartTime = wednesdayStartTime;
    }

    public String getWednesdayEndTime() {
        return wednesdayEndTime;
    }

    public void setWednesdayEndTime(String wednesdayEndTime) {
        this.wednesdayEndTime = wednesdayEndTime;
    }

    public String getThursdayStartTime() {
        return thursdayStartTime;
    }

    public void setThursdayStartTime(String thursdayStartTime) {
        this.thursdayStartTime = thursdayStartTime;
    }

    public String getThursdayEndTime() {
        return thursdayEndTime;
    }

    public void setThursdayEndTime(String thursdayEndTime) {
        this.thursdayEndTime = thursdayEndTime;
    }

    public String getFridayStartTime() {
        return fridayStartTime;
    }

    public void setFridayStartTime(String fridayStartTime) {
        this.fridayStartTime = fridayStartTime;
    }

    public String getFridayEndTime() {
        return fridayEndTime;
    }

    public void setFridayEndTime(String fridayEndTime) {
        this.fridayEndTime = fridayEndTime;
    }

    @PropertyName("dayOfWeek")
    public String getDayOfWeek() {
        return dayOfWeek;
    }

    @PropertyName("dayOfWeek")
    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }
    public String getDayAndTimeRange() {
        if (dayOfWeek != null && mondayStartTime != null && mondayEndTime != null) {
            return dayOfWeek + " " + mondayStartTime + " - " + mondayEndTime;
        } else if (dayOfWeek != null && tuesdayStartTime != null && tuesdayEndTime != null) {
            return dayOfWeek + " " + tuesdayStartTime + " - " + tuesdayEndTime;
        } else if (dayOfWeek != null && wednesdayStartTime != null && wednesdayEndTime != null) {
            return dayOfWeek + " " + wednesdayStartTime + " - " + wednesdayEndTime;
        } else if (dayOfWeek != null && thursdayStartTime != null && thursdayEndTime != null) {
            return dayOfWeek + " " + thursdayStartTime + " - " + thursdayEndTime;
        } else if (dayOfWeek != null && fridayStartTime != null && fridayEndTime != null) {
            return dayOfWeek + " " + fridayStartTime + " - " + fridayEndTime;
        }
        // 이 외의 경우에 대한 처리 추가
        return "";
    }
    public String getDayAndTimeRange2() {
        if (dayOfWeek2 != null && mondayStartTime2 != null && mondayEndTime2 != null) {
            return dayOfWeek2 + " " + mondayStartTime2 + " - " + mondayEndTime2;
        } else if (dayOfWeek2 != null && tuesdayStartTime2 != null && tuesdayEndTime2 != null) {
            return dayOfWeek2 + " " + tuesdayStartTime2 + " - " + tuesdayEndTime2;
        } else if (dayOfWeek2 != null && wednesdayStartTime2 != null && wednesdayEndTime2 != null) {
            return dayOfWeek2 + " " + wednesdayStartTime2 + " - " + wednesdayEndTime2;
        } else if (dayOfWeek2 != null && thursdayStartTime2 != null && thursdayEndTime2 != null) {
            return dayOfWeek2 + " " + thursdayStartTime2 + " - " + thursdayEndTime2;
        } else if (dayOfWeek2 != null && fridayStartTime2 != null && fridayEndTime2 != null) {
            return dayOfWeek2 + " " + fridayStartTime2 + " - " + fridayEndTime2;
        }
        // 이 외의 경우에 대한 처리 추가
        return "";
    }
}