package com.bhu.mess.model;

import java.sql.Date;

public class MessRegistration {
    private int id;
    private String email;
    private String messName;
    private Date joiningDate;
    private String mealType;

    // Getters and setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessName() {
        return messName;
    }
    public void setMessName(String messName) {
        this.messName = messName;
    }

    public Date getJoiningDate() {
        return joiningDate;
    }
    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }

    public String getMealType() {
        return mealType;
    }
    public void setMealType(String mealType) {
        this.mealType = mealType;
    }
}
