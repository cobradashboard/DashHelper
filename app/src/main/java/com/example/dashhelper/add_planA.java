package com.example.dashhelper;


public class add_planA {
    private String workoutName;
    private String startingTime;
    private String endingTime;
    private int distance;
    private String ID;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getWorkoutName() {
        return workoutName;
    }

    public void setWorkoutName(String workoutName) {
        this.workoutName = workoutName;
    }

    public String getStartingTime() {
        return startingTime;
    }

    public void setStartingTime(String startingTime) {
        this.startingTime = startingTime;
    }



    public String getEndingTime() {
        return endingTime;
    }

    public void setEndingTime(String endingTime) {
        this.endingTime = endingTime;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public add_planA(String workoutName, String startingTime, String endingTime, int distance, String id) {
        this.workoutName = workoutName;
        this.startingTime = startingTime;
        this.endingTime = endingTime;
        this.distance = distance;
        this.ID = id;
    }

    public add_planA() {
    }

    public String toString(){
        return this.startingTime+"\n"+endingTime+"\n"+distance;
    }

}
