package com.example.dashhelper;


public class add_planA {
    private String workoutName;
    private String startingTime;
    private String endingTime;
    private int distance;

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

    public add_planA(String workoutName, String startingTime, String endingTime, int distance) {
        this.workoutName = workoutName;
        this.startingTime = startingTime;
        this.endingTime = endingTime;
        this.distance = distance;
    }

    public add_planA() {
    }

    public String toString(){
        return this.workoutName + " - "+startingTime+" - "+endingTime+" - "+distance;
    }

}
