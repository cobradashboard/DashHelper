package com.example.dashhelper;

import java.io.Serializable;

public class newaddexammodel implements Serializable {
    private String exam;
    private String subject;
    private String place;
    private String date;
    private String ID;


    public newaddexammodel() {
    }

    public newaddexammodel(String exam, String subject, String place, String date, String ID) {
        this.exam = exam;
        this.subject = subject;
        this.place = place;
        this.date = date;
        this.ID = ID;
    }

    public String getExam() {
        return exam;
    }

    public void setExam(String exam) {
        this.exam = exam;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String toString(){
        return this.exam+" \n "+subject+"\n  "+place+" \n "+date;
    }
}
