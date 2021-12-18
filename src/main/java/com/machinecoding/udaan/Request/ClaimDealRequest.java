package com.machinecoding.udaan.Request;

public class ClaimDealRequest {
    int deal_id;
    int user_id;

    public ClaimDealRequest(int deal_id, int user_id) {
        this.deal_id = deal_id;
        this.user_id = user_id;
    }

    public int getDeal_id() {
        return deal_id;
    }

    public void setDeal_id(int deal_id) {
        this.deal_id = deal_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
