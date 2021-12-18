package com.machinecoding.udaan.Request;

import java.time.LocalDateTime;

public class DealRequest {
    int deal_id;
    String deal_name;
    int maxAllowedDeal;
    LocalDateTime startTime;
    LocalDateTime endTime;

    public int getDeal_id() {
        return deal_id;
    }

    public void setDeal_id(int deal_id) {
        this.deal_id = deal_id;
    }

    public String getDeal_name() {
        return deal_name;
    }

    public void setDeal_name(String deal_name) {
        this.deal_name = deal_name;
    }

    public int getMaxAllowedDeal() {
        return maxAllowedDeal;
    }

    public void setMaxAllowedDeal(int maxAllowedDeal) {
        this.maxAllowedDeal = maxAllowedDeal;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public DealRequest(int deal_id, String deal_name, int maxAllowedDeal, int currentDeal, LocalDateTime startTime, LocalDateTime endTime) {
        this.deal_id = deal_id;
        this.deal_name = deal_name;
        this.maxAllowedDeal = maxAllowedDeal;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
