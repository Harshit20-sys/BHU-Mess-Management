package com.bhu.mess.model;

public class Menu {
    private int id;
    private String day;
    private String breakfast;
    private String lunch;
    private String dinner;

    // Getters and setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getDay() {
        return day;
    }
    public void setDay(String day) {
        this.day = day;
    }

    public String getBreakfast() {
        return breakfast;
    }
    public void setBreakfast(String breakfast) {
        this.breakfast = breakfast;
    }

    public String getLunch() {
        return lunch;
    }
    public void setLunch(String lunch) {
        this.lunch = lunch;
    }

    public String getDinner() {
        return dinner;
    }
    public void setDinner(String dinner) {
        this.dinner = dinner;
    }
}
