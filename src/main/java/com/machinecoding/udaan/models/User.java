package com.machinecoding.udaan.models;

import java.util.List;

public class User {
    int user_id;
    String user_name;
    String user_email;
    String user_phone;
    List<Integer> claimedDeals;

    public User(int user_id, String user_name, String user_email, String user_phone, List<Integer> claimedDeals) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_email = user_email;
        this.user_phone = user_phone;
        this.claimedDeals = claimedDeals;
    }

    public List<Integer> getClaimedDeals() {
        return claimedDeals;
    }

    public void setClaimedDeals(List<Integer> claimedDeals) {
        this.claimedDeals = claimedDeals;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }
}
