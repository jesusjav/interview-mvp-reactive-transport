package com.coding.framework.mvp.data.model;

/**
 * Created by Jesus Morales on 23-08-2018.
 */

public abstract class BoardingCards {

    protected String departure, arrival, seat;

    public BoardingCards(String departure, String arrival, String seat) {
        this.departure = departure;
        this.arrival = arrival;
        this.seat = seat;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public abstract String toString();

}
